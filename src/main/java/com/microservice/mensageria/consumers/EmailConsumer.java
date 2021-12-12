package com.microservice.mensageria.consumers;

import com.microservice.mensageria.dtos.EmailDTO;
import com.microservice.mensageria.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        emailService.enviaEmail(emailDTO);
        System.out.println("Email Status " + emailDTO.getStatusEmail().toString());
    }
}
