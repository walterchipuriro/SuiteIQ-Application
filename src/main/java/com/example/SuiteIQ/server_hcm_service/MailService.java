package com.example.SuiteIQ.server_hcm_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetEmail(String to, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Password Reset Request");
        message.setText("Hi,\n\nClick the link below to reset your password:\n" + resetLink + "\n\nThis link expires in 15 minutes.");
        message.setFrom("suite_iq@gmail.com");

        mailSender.send(message);
    }
}
