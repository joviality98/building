package com.building.service.impl;

import com.building.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String acceptOrderMail(String userName, String userEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1538295090@qq.com");
        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("您有新的维修工单待接受");
        simpleMailMessage.setText("亲爱的"+userName+"先生/女生，您有新的维修工单待接受，请尽快前往系统确认接单");
        simpleMailMessage.setSentDate(new Date());
        javaMailSender.send(simpleMailMessage);
        return "OK";
    }

    @Override
    public String completeOrderMail(String userName, String userEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1538295090@qq.com");
        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("【维修完成】感谢您的反馈，维修工单已完成");
        simpleMailMessage.setText("亲爱的"+userName+"先生/女生，您提交的工单已维修完成，感谢您的反馈!");
        simpleMailMessage.setSentDate(new Date());
        javaMailSender.send(simpleMailMessage);
        return "OK";
    }
}
