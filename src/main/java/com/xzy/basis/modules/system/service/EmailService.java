package com.xzy.basis.modules.system.service;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 10:18 2020/2/26
 */
public interface EmailService {
    /**
     * 发送文本邮件
     * @param to 邮件接收人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleEmail(String to, String subject, String content);

    /**
     * 发送html邮件
     * @param to 邮件接收人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendHtmlEmail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to 邮件接收人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param filePath 附件地址
     */
    void sendAttachmentsEmail(String to, String subject, String content, String filePath);

    /**
     * 发送抄送邮件
     * @param to 邮件接收人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param cc 抄送
     */
    void sendCcEmail(String to, String subject, String content, String cc);

    /**
     * 根据模板发送文件
     * @param to 邮件接收人
     * @param subject 邮件主题
     * @param param 邮件内容
     * @param templateName 模板名称
     */
    void sendTemplateMail(String to, String subject, String templateName, Object param);
}
