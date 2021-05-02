package com.mandiri.tokonyadianotification.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandiri.tokonyadianotification.dto.PurchaseDto;
import com.mandiri.tokonyadianotification.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification {

    Logger logger = LoggerFactory.getLogger(EmailNotification.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MailService mailService;

    @KafkaListener(id = "email-notif", groupId = "email-notif", topics = "simple-notification")
    public void listen(String message) throws JsonProcessingException {
        logger.info("Message : " + message);
        PurchaseDto purchaseDto = objectMapper.readValue(message, PurchaseDto.class);
        mailService.sendEmail(purchaseDto);
    }


}
