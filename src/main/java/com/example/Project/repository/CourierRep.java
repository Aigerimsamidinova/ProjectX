package com.example.Project.repository;

import com.example.Project.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRep
        extends JpaRepository<Courier,Long> {
}
