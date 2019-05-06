package com.example.Project.service;

import com.example.Project.model.Application;
import com.example.Project.repository.AppRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppServiceImpl implements CrudService<Application> {
    @Autowired
    private AppRep appRep;

    @Override
    public List<Application> getAll() {
        return appRep.findAll();
    }

    @Override
    public Application findById(Long id) {
        return appRep.findById(id).get();
    }

    @Override
    public Application save(Application application) {
        return appRep.save(application);
    }

    @Override
    public Application update(Application application) {
        return appRep.save(application
        );
    }

    @Override
    public void deleteById(Long id) {
        appRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
        appRep.deleteAll();
    }
}
