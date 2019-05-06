package com.example.Project.service;

import com.example.Project.model.Courier;
import com.example.Project.repository.CourierRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServicelmpl implements CrudService<Courier> {
    @Autowired
    private CourierRep courierRep;

    @Override
    public List<Courier> getAll() {
        return courierRep.findAll();
    }

    @Override
    public Courier findById(Long id) {
        return courierRep.findById(id).get();
    }

    @Override
    public Courier save(Courier courier) {
        return courierRep.save(courier);
    }

    @Override
    public Courier update(Courier courier) {
        return courierRep.save(courier);
    }

    @Override
    public void deleteById(Long id) {
        courierRep.deleteById(id);
    }
    @Override
    public void deleteAll() {
        courierRep.deleteAll();
    }
}
