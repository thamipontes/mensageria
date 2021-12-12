package com.microservice.mensageria.services;

import com.microservice.mensageria.dtos.EmailDTO;
import com.microservice.mensageria.enums.StatusEmail;
import com.microservice.mensageria.model.Email;
import com.microservice.mensageria.repositories.EmailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public Email enviaEmail(EmailDTO emailDTO) {
        emailDTO.setDataEnvio(LocalDateTime.now());

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(emailDTO.getEmailFrom());
            simpleMailMessage.setTo(emailDTO.getEmailTo());
            simpleMailMessage.setSubject(emailDTO.getAssunto());
            simpleMailMessage.setText(emailDTO.getTexto());
            emailSender.send(simpleMailMessage);

            emailDTO.setStatusEmail(StatusEmail.ENVIADO);

        } catch (MailException e){
            emailDTO.setStatusEmail(StatusEmail.ERRO);
        } finally {
            return salvarDadosEmail(emailDTO);
        }
    }

    private Email salvarDadosEmail(EmailDTO emailDTO){
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailRepository.save(email);
        return email;
    }
}
