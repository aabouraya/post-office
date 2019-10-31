package com.knowhow.postoffice.service.impl;

import com.knowhow.postoffice.contract.EmailDto;
import com.knowhow.postoffice.service.EmailService;
import com.knowhow.postoffice.service.StreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StreamServiceImpl implements StreamService {

    private final EmailService emailService;

    @Override
    @StreamListener(Sink.INPUT)
    public void emailListener(EmailDto msg) {
        emailService.send(msg);
    }

}
