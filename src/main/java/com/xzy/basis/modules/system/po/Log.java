package com.xzy.basis.modules.system.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "basis_log")
public class Log {
    /**
     * ����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * �û���
     */
    private String username;

    /**
     * �û�ip
     */
    private String ip;

    /**
     * ���󷽷�
     */
    @Column(name = "req_method")
    private String reqMethod;

    /**
     * ִ�з���
     */
    @Column(name = "exec_method")
    private String execMethod;

    /**
     * ��Ӧʱ��
     */
    @Column(name = "exec_time")
    private Long execTime;

    /**
     * ����
     */
    @Column(name = "exec_desc")
    private String execDesc;

    /**
     * ״̬
     */
    private String status;

    /**
     * ����ʱ��
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * ����URL
     */
    @Column(name = "req_uri")
    private String reqUri;

    /**
     * ����
     */
    private String args;

    /**
     * ����ֵ
     */
    @Column(name = "return_val")
    private String returnVal;

    /**
     * ��ȡ����
     *
     * @return id - ����
     */
    public Long getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * ��ȡ�û���
     *
     * @return username - �û���
     */
    public String getUsername() {
        return username;
    }

    /**
     * �����û���
     *
     * @param username �û���
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡ�û�ip
     *
     * @return ip - �û�ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * �����û�ip
     *
     * @param ip �û�ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * ��ȡ���󷽷�
     *
     * @return req_method - ���󷽷�
     */
    public String getReqMethod() {
        return reqMethod;
    }

    /**
     * �������󷽷�
     *
     * @param reqMethod ���󷽷�
     */
    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    /**
     * ��ȡִ�з���
     *
     * @return exec_method - ִ�з���
     */
    public String getExecMethod() {
        return execMethod;
    }

    /**
     * ����ִ�з���
     *
     * @param execMethod ִ�з���
     */
    public void setExecMethod(String execMethod) {
        this.execMethod = execMethod;
    }

    /**
     * ��ȡ��Ӧʱ��
     *
     * @return exec_time - ��Ӧʱ��
     */
    public Long getExecTime() {
        return execTime;
    }

    /**
     * ������Ӧʱ��
     *
     * @param execTime ��Ӧʱ��
     */
    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    /**
     * ��ȡ����
     *
     * @return exec_desc - ����
     */
    public String getExecDesc() {
        return execDesc;
    }

    /**
     * ��������
     *
     * @param execDesc ����
     */
    public void setExecDesc(String execDesc) {
        this.execDesc = execDesc;
    }

    /**
     * ��ȡ״̬
     *
     * @return status - ״̬
     */
    public String getStatus() {
        return status;
    }

    /**
     * ����״̬
     *
     * @param status ״̬
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * ��ȡ����ʱ��
     *
     * @return create_time - ����ʱ��
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * ���ô���ʱ��
     *
     * @param createTime ����ʱ��
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��ȡ����URL
     *
     * @return req_uri - ����URL
     */
    public String getReqUri() {
        return reqUri;
    }

    /**
     * ��������URL
     *
     * @param reqUri ����URL
     */
    public void setReqUri(String reqUri) {
        this.reqUri = reqUri;
    }

    /**
     * ��ȡ����
     *
     * @return args - ����
     */
    public String getArgs() {
        return args;
    }

    /**
     * ���ò���
     *
     * @param args ����
     */
    public void setArgs(String args) {
        this.args = args;
    }

    /**
     * ��ȡ����ֵ
     *
     * @return return_val - ����ֵ
     */
    public String getReturnVal() {
        return returnVal;
    }

    /**
     * ���÷���ֵ
     *
     * @param returnVal ����ֵ
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