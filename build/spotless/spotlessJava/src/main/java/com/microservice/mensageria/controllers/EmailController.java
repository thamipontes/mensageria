package com.microservice.mensageria.controllers;

import com.microservice.mensageria.dtos.EmailDTO;
import com.microservice.mensageria.dtos.UsuarioDTO;
import com.microservice.mensageria.services.EmailService;
import feign.FeignException;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    UsuarioClient usuarioClient;

    @PostMapping("/envia-email")
    public ResponseEntity<?> enviaEmail(@RequestBody @Valid EmailDTO emailDTO) {
        try {
            List<UsuarioDTO> usuarioDTO = usuarioClient.pegarTodosUsuarioClient();
            usuarioDTO.forEach(usuario -> {
                emailDTO.setProprietario(usuario.getNomeCompleto());
                emailService.enviaEmail(emailDTO);
            });
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        } catch (FeignException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
