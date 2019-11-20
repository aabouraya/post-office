package com.knowhow.postoffice.service.impl;

import com.knowhow.postoffice.config.AppProperties;
import com.knowhow.postoffice.contract.EmailDto;
import com.knowhow.postoffice.service.EmailService;
import com.knowhow.postoffice.service.TemplateService;
import java.nio.charset.StandardCharsets;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final TemplateService templateService;
    private final AppProperties appProperties;

    @Override
    @Async("emailPoolTaskExecutor")
    public void send(EmailDto msg) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(msg.getTo());
            String messageBody = templateService.load(msg.getTemplate().name(), msg.getModel());
            helper.setText(messageBody, true);
            helper.setSubject(msg.getSubject());
            helper.setFrom(appProperties.getApp().getFromEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }
}
