package com.mandiri.tokonyadianotification.service;

import com.mandiri.tokonyadianotification.dto.PurchaseDto;

public interface MailService {

    public void sendEmail(PurchaseDto purchaseDto);
}
