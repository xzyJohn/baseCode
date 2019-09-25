package com.xzy.basis.core.exception;

import com.xzy.basis.core.utils.Result;
import com.xzy.basis.core.utils.ResultCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xzy
 * @date 2019/9/3 13:26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> handleThrowable(HttpServletRequest request, Throwable e) {
        return Result.failure(ResultCodeEnum.INTERNAL_SERVER_ERROR)
                .addExtra("stackTrace", e.getStackTrace())
                .addExtra("exceptionMessage", e.getClass().getName() + ":" + e.getMessage());
    }

    /**
     * 服务异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({BizException.class})
    public Result<Object> handleBizException(HttpServletRequest request, BizException e) {
        return Result.failure(ResultCodeEnum.PARAM_ERROR)
                .addExtra("stackTrace", e.getStackTrace())
                .addExtra("exceptionMessage", e.getClass().getName() + ":" + e.getMessage());
    }

    /**
     * 参数校验异常
     * 使用 @Valid 注解，方法上加@RequestBody注解修饰的方法未校验通过会抛MethodArgumentNotValidException，否则抛BindException。
     * 使用 @Validated 注解，未校验通过会抛ConstraintViolationException
     * 关于 @Valid和@Validated注解的区别:
     * 这两个注解都是实现JSR-303规范，不同的是@Validated是spring的注解支持groups以及可以用在spring mvc处理器的方法级别入参验证 ，@Valid是Javax提供的注解，可以支持多个bean嵌套验证。
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, ConstraintViolationException.class})
    public Result<Object> handleJSP303Exception(HttpServletRequest request, Exception e) {
        BindingResult br = null;
        Result result = new Result()
                .setSuccess(false)
                .setCode(ResultCodeEnum.PARAM_ERROR.getCode())
                .setMsg(ResultCodeEnum.PARAM_ERROR.getMsg())
                .addExtra("stackTrace", e.getStackTrace())
                .addExtra("exceptionMessage", e.getClass().getName() + ":" + e.getMessage());

        if (e instanceof BindingResult) {
            br = ((BindException) e).getBindingResult();
        }
        if (e instanceof MethodArgumentNotValidException) {
            br = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        if (br != null) {
            return result.setData(
                    br.getFieldErrors().stream()
                            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (oldValue, newValue) -> oldValue.concat(",").concat(newValue)))
            ).setMsg(
                    br.getFieldErrors().stream()
                            .map(f -> f.getField().concat(f.getDefaultMessage()))
                            .collect(Collectors.joining(","))
            );
        }
        if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            return result
                    .setData(
                            constraintViolations.stream().collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage))
                    )
                    .setMsg(e.getMessage());
        }
        return result;
    }
}
