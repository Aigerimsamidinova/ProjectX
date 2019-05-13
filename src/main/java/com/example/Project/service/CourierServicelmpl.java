package com.example.Project.service;

import com.example.Project.enums.StatusApp;
import com.example.Project.model.Application;
import com.example.Project.model.Courier;
import com.example.Project.repository.AppRep;
import com.example.Project.repository.CourierRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServicelmpl implements CrudService<Courier>, CourierService {
    @Autowired
    private CourierRep courierRep;

    @Autowired
    private AppRep appRep;

    @Override
    public Application changeApplicationStatus(Long courierId, Long appId, String code) {
        Application application = appRep.findById(appId).get();
        if(code.equals("+")){
            application.setStatusApp(StatusApp.ACCEPTED);
        }
        else if(code.equals("-")){
            application.setStatusApp(StatusApp.REFUSED);
        }
        appRep.save(application);
        return application;
    }

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
