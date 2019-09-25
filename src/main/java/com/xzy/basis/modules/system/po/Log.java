package com.xzy.basis.modules.system.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "basis_log")
public class Log {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户ip
     */
    private String ip;

    /**
     * 请求方法
     */
    @Column(name = "req_method")
    private String reqMethod;

    /**
     * 执行方法
     */
    @Column(name = "exec_method")
    private String execMethod;

    /**
     * 响应时间
     */
    @Column(name = "exec_time")
    private Long execTime;

    /**
     * 描述
     */
    @Column(name = "exec_desc")
    private String execDesc;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 请求URL
     */
    @Column(name = "req_uri")
    private String reqUri;

    /**
     * 参数
     */
    private String args;

    /**
     * 返回值
     */
    @Column(name = "return_val")
    private String returnVal;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户ip
     *
     * @return ip - 用户ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置用户ip
     *
     * @param ip 用户ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取请求方法
     *
     * @return req_method - 请求方法
     */
    public String getReqMethod() {
        return reqMethod;
    }

    /**
     * 设置请求方法
     *
     * @param reqMethod 请求方法
     */
    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    /**
     * 获取执行方法
     *
     * @return exec_method - 执行方法
     */
    public String getExecMethod() {
        return execMethod;
    }

    /**
     * 设置执行方法
     *
     * @param execMethod 执行方法
     */
    public void setExecMethod(String execMethod) {
        this.execMethod = execMethod;
    }

    /**
     * 获取响应时间
     *
     * @return exec_time - 响应时间
     */
    public Long getExecTime() {
        return execTime;
    }

    /**
     * 设置响应时间
     *
     * @param execTime 响应时间
     */
    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    /**
     * 获取描述
     *
     * @return exec_desc - 描述
     */
    public String getExecDesc() {
        return execDesc;
    }

    /**
     * 设置描述
     *
     * @param execDesc 描述
     */
    public void setExecDesc(String execDesc) {
        this.execDesc = execDesc;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取请求URL
     *
     * @return req_uri - 请求URL
     */
    public String getReqUri() {
        return reqUri;
    }

    /**
     * 设置请求URL
     *
     * @param reqUri 请求URL
     */
    public void setReqUri(String reqUri) {
        this.reqUri = reqUri;
    }

    /**
     * 获取参数
     *
     * @return args - 参数
     */
    public String getArgs() {
        return args;
    }

    /**
     * 设置参数
     *
     * @param args 参数
     */
    public void setArgs(String args) {
        this.args = args;
    }

    /**
     * 获取返回值
     *
     * @return return_val - 返回值
     */
    public String getReturnVal() {
        return returnVal;
    }

    /**
     * 设置返回值
     *
     * @param returnVal 返回值
     */
    public void setReturnVal(String returnVal) {
        this.returnVal = returnVal;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", reqMethod='" + reqMethod + '\'' +
                ", execMethod='" + execMethod + '\'' +
                ", execTime=" + execTime +
                ", execDesc='" + execDesc + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", reqUri='" + reqUri + '\'' +
                ", args='" + args + '\'' +
                ", returnVal='" + returnVal + '\'' +
                '}';
    }
}