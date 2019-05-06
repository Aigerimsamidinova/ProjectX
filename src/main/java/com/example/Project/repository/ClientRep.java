package com.example.Project.repository;

import com.example.Project.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRep extends JpaRepository<Client, Long> {
}
