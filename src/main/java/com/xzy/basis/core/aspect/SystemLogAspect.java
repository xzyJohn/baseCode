package com.xzy.basis.core.aspect;

import com.xzy.basis.core.annotation.SystemLog;
import com.xzy.basis.core.utils.JsonUtil;
import com.xzy.basis.core.utils.PageResultSet;
import com.xzy.basis.core.utils.Result;
import com.xzy.basis.core.utils.WebUtil;
import com.xzy.basis.modules.system.po.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xzy
 * @date 2019/9/10 15:19
 */
@Aspect
@Component
public class SystemLogAspect {
    @Pointcut("@annotation(systemLog)")
    public void systemLogPointcut(SystemLog systemLog) {
    }

    @Around("systemLogPointcut(systemLog)")
    public Object aroundMethod(ProceedingJoinPoint point, SystemLog systemLog) throws Throwable {
        long time = System.currentTimeMillis();
        try {
            Object returns = point.proceed();
            save(point, returns, systemLog, System.currentTimeMillis() - time);
            return returns;
        } catch (Throwable e) {
            save(point, e, systemLog, System.currentTimeMillis() - time);
            throw e;
        }
    }

    private void save(ProceedingJoinPoint point, Object returns, SystemLog systemLog, Long time) {
        String sign = point.getSignature().toString();
        //获取相关参数
        WebUtil webUtil = WebUtil.getInstance();
        //请求对象
        HttpServletRequest request = webUtil.getRequest();
        //当前用户
        String username = "admin";
        //查询参数
        String querystring = request.getQueryString();
        //url
        String url = request.getRequestURL().append(querystring == null ? "" : "?" + querystring).toString();
        //IP地址
        String ip = webUtil.getIpAddress();
        //方法
        String method = request.getMethod();
        //协议
        String protocol = request.getProtocol();

        String status = null;

        String message = null;

        String desc = !StringUtils.isEmpty(systemLog.desc()) ? systemLog.desc() : systemLog.value();

        if (returns != null && returns instanceof Result) {
            Result result = (Result) returns;
            status = result.getCode();
            message = result.getMsg();
        }

        if (returns != null && returns instanceof PageResultSet) {
            message = "查询成功";
            status = HttpStatus.OK.toString();
        }

        String text = null;
        if (returns != null) {
            String tmp;
            if (returns instanceof CharSequence) {
                tmp = returns.toString();
            } else if (returns instanceof Throwable) {
                String m = ((Throwable) returns).getMessage();
                String n = returns.getClass().getSimpleName();
                tmp = m == null ? n : n + ":" + m;
            } else {
                tmp = JsonUtil.getInstance().obj2json(returns);
            }
            text=tmp;
        }
        Log log = new Log();
        // 用户信息
        log.setUsername(username);
        // 请求信息
        log.setIp(ip);
        log.setReqMethod(method + " " + protocol);
        log.setReqUri(url);
        // 执行信息
        log.setExecMethod(sign);
        log.setExecTime(time);
        // 请求参数
        if ("POST".equals(method)) {
            log.setArgs(JsonUtil.getInstance().obj2json(point.getArgs()[0]));
        }
        log.setStatus(message);
        log.setExecDesc(desc);
        // 响应信息
        log.setReturnVal(text);

        System.out.println(log);
    }

}

