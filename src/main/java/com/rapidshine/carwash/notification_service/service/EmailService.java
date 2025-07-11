package com.rapidshine.carwash.notification_service.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;
    public void sendSimpleEmail(String toEmail,String subject, String body){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body);
            mailSender.send(message);

        }catch (MessagingException e) {
            throw new RuntimeException("Filed to send HTML email",e);
        }
    }

    public void sendOtpEmail(String toEmail,String otp){
        Context context = new Context();
        context.setVariable("otp",otp);
        String htmlBody = templateEngine.process("otp-email",context);
        sendSimpleEmail(toEmail,"Your OTP Code",htmlBody);

    }
    public void sendCustomEmailWithHtml(String toEmail, String subject, String htmlContent) {
        sendSimpleEmail(toEmail, subject, htmlContent);
    }
}
