package com.example.Project.repository;

import com.example.Project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRep
        extends JpaRepository<Item,Long> {
}
