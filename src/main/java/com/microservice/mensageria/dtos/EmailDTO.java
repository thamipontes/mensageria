package com.microservice.mensageria.dtos;

import com.microservice.mensageria.enums.StatusEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmailDTO {

    @NotBlank
    private String proprietario;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    @Email
    private String emailTo;

    @NotBlank
    private String assunto;

    @NotBlank
    private String texto;

    private LocalDateTime dataEnvio;
    private StatusEmail statusEmail;

}
