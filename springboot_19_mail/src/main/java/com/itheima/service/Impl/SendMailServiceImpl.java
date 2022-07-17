package com.itheima.service.Impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * @ClassName: SendMail
 * @author: mafangnian
 * @date: 2022/7/14 16:13
 * @Blog: null
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    //发送人
    private String from = "2976908894@qq.com";
    //接收人
    private String to = "1295773125@qq.com";
    //标题
    private String subject = "测试邮件";
    //测试邮件正文
    private String context = "<a href='https://lulyqqqq.github.io/'>博客</a>";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void SendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context,true);
            //添加附件
            File f1 = new File("src/main/resources/111.jpg");
            helper.addAttachment("图片.jpg",f1);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
