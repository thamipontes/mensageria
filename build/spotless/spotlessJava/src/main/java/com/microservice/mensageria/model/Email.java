package com.microservice.mensageria.model;

import com.microservice.mensageria.enums.StatusEmail;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;

    private String proprietario;
    private String emailFrom;
    private String emailTo;
    private String assunto;
    private LocalDateTime dataEnvio;
    private StatusEmail statusEmail;

    @Column(columnDefinition = "TEXT")
    private String texto;
}
