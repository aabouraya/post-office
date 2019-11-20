package com.knowhow.postoffice.service;

import com.knowhow.postoffice.contract.EmailDto;

public interface StreamService {

    void emailListener(EmailDto msg);
}
