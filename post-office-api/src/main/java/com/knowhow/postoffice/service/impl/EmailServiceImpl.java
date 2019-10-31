package com.knowhow.postoffice.service.impl;

import com.knowhow.postoffice.contract.EmailDto;
import com.knowhow.postoffice.service.EmailService;
import com.knowhow.postoffice.service.TemplateService;
import java.nio.charset.StandardCharsets;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final TemplateService templateService;


    @Override
    public void send(EmailDto msg) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(msg.getTo());
            String tosend = templateService.load("activate", msg.getModel());
            helper.setText(tosend, true);
            helper.setSubject(msg.getSubject());
            helper.setFrom("admin@shiled.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }
}
