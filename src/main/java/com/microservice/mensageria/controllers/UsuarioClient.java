package com.microservice.mensageria.controllers;

import com.microservice.mensageria.configs.UsuarioClientConfig;
import com.microservice.mensageria.dtos.UsuarioDTO;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "usuarioClient", url = "https://folha-ponto-backend.herokuapp.com", configuration = UsuarioClientConfig.class)
public interface UsuarioClient {
    @GetMapping(value = "/usuario")
    List<UsuarioDTO> pegarTodosUsuarioClient();
}
