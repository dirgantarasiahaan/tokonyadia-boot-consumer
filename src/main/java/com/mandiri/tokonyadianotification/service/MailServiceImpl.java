package com.mandiri.tokonyadianotification.service;

import com.mandiri.tokonyadianotification.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;

    @Override
    public void sendEmail(PurchaseDto purchaseDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(purchaseDto.getEmailTo());
        simpleMailMessage.setFrom(email);
        simpleMailMessage.setSubject("Invoice Tokonyadia");
        simpleMailMessage.setText("Berhasil mellakukan pemabayaran sebesar : " + purchaseDto.getAmount() + " Rupiah");
        javaMailSender.send(simpleMailMessage);

    }
}
