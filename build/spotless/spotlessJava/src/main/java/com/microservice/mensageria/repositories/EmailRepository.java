package com.microservice.mensageria.repositories;

import com.microservice.mensageria.model.Email;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, UUID> {}
