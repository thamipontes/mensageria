package com.microservice.mensageria.controllers;

import com.microservice.mensageria.dtos.EmailDTO;
import com.microservice.mensageria.model.Email;
import com.microservice.mensageria.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/envia-email")
    public ResponseEntity<Email> enviaEmail(@RequestBody @Valid EmailDTO emailDTO){
        Email email = emailService.enviaEmail(emailDTO);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }


}
