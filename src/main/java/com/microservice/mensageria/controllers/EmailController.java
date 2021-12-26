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

    @PostMapping("/envia-email-registro")
    public ResponseEntity<?> enviaEmailUsuarioRegistro(@RequestBody @Valid String emailUsuario) {
        try {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setEmailPara(emailUsuario);
            emailDTO.setAssunto("Sua conta foi criada!");
            emailDTO.setTexto("Parabéns, sua conta foi criada no meu projetinho Folha de Ponto! \n" +
                    "Dúvidas sobre o projeto acesse meu GitHub:\n" +
                    "Backend:  https://github.com/thamipontes/folhaPonto\n" +
                    "Frontend: https://github.com/thamipontes/folha-ponto-frontend\n" +
                    "Mensageria: https://github.com/thamipontes/mensageria");
            emailDTO.setEmailFrom("microservice.socorro@gmail.com");
            emailService.enviaEmail(emailDTO);
            return new ResponseEntity<>(emailDTO, HttpStatus.OK);
        } catch (FeignException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
