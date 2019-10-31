package com.knowhow.postoffice.service;

import com.knowhow.postoffice.contract.EmailDto;

public interface EmailService {

    void send(EmailDto msg);
}
