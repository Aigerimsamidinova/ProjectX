package com.example.Project.service;

import com.example.Project.model.Office;
import com.example.Project.repository.OfficeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServicelmpl implements CrudService<Office> {
    @Autowired
    private OfficeRep officeRep;

    @Override
    public List<Office> getAll() {
        return officeRep.findAll();
    }

    @Override
    public Office findById(Long id) {
        return officeRep.findById(id).get();
    }

    @Override
    public Office save(Office office) {
        return officeRep.save(office);
    }

    @Override
    public Office update(Office office) {
        return officeRep.save(office);
    }

    @Override
    public void deleteById(Long id) {
        officeRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
        officeRep.deleteAll();
    }
}
