package com.example.Project.repository;

import com.example.Project.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRep
        extends JpaRepository<Office,Long> {
}
