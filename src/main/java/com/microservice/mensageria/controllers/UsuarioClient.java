package com.microservice.mensageria.controllers;

import com.microservice.mensageria.dtos.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8080/usuario/", name = "usuario")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTO pegaUsuario(@RequestBody String proprietario);

}
