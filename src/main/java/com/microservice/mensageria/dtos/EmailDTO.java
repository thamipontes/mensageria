package com.microservice.mensageria.dtos;

import com.microservice.mensageria.enums.StatusEmail;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {

    @NotBlank
    private String proprietario;

    @NotBlank
    @Email
    private String emailFrom;

    @Email
    private String emailPara;

    @NotBlank
    private String assunto;

    @NotBlank
    private String texto;

    private LocalDateTime dataEnvio;
    private StatusEmail statusEmail;
}
