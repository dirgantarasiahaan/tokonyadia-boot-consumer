package com.mandiri.tokonyadianotification.service;

import com.mandiri.tokonyadianotification.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(PurchaseDto purchaseDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("nikolassihombing69@gmail.com");
        simpleMailMessage.setFrom(purchaseDto.getEmailSender());
        simpleMailMessage.setSubject("Invoice Tokonyadia");
        simpleMailMessage.setText("Berhasil mellakukan pemabayaran sebesar : " + purchaseDto.getAmount() + " Rupiah");
        javaMailSender.send(simpleMailMessage);

    }
}
