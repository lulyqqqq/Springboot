package com.itheima.service.Impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SendMail
 * @author: mafangnian
 * @date: 2022/7/14 16:13
 * @Blog: null
 */
//@Service
public class SendMailServiceImpl2 implements SendMailService {

    //发送人
    private String from = "2976908894@qq.com";
    //接收人
    private String to = "1295773125@qq.com";
    //标题
    private String subject = "测试邮件";
    //测试邮件正文
    private String context = "测试邮件正文内容";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void SendMail() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
