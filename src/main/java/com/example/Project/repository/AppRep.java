package com.example.Project.repository;

import com.example.Project.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRep extends JpaRepository<Application, Long> {
}
