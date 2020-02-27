package com.xzy.basis.modules.system.service.impl;

import com.xzy.basis.modules.system.service.EmailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 10:24 2020/2/26
 */
@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    @Resource
    private FreeMarkerConfigurer configurer;

    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage message=new SimpleMailMessage();
        //发送人
        message.setFrom(from);
        //接收人
        message.setTo(to);
        //主题
        message.setSubject(subject);
        //内容
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void sendHtmlEmail(String to, String subject, String content) {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper=new MimeMessageHelper(message,true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAttachmentsEmail(String to, String subject, String content, String filePath) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource file=new FileSystemResource(new File(filePath));
            String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName,file);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendCcEmail(String to, String subject, String content, String cc) {
        SimpleMailMessage message=new SimpleMailMessage();
        //发送人
        message.setFrom(from);
        //接收人
        message.setTo(to);
        //抄送
        message.setCc(cc);
        //主题
        message.setSubject(subject);
        //内容
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void sendTemplateMail(String to, String subject, String templateName,Object param) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            //设置发送者
            helper.setFrom(from);
            //设置发送给谁
            helper.setTo(to);
            //设置发送主题
            helper.setSubject(subject);

            Map<String,Object> model=new HashMap<>(16);
            model.put("params",param);
            try {
                Template template=configurer.getConfiguration().getTemplate(templateName);
                try {
                    String text= FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
                    helper.setText(text,true);
                    mailSender.send(mimeMessage);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
