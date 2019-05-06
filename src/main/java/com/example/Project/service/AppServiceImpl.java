package com.example.Project.service;

import com.example.Project.enums.StatusItem;
import com.example.Project.model.Application;
import com.example.Project.model.Item;
import com.example.Project.repository.AppRep;
import com.example.Project.repository.ItemRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements CrudService<Application> {
    @Autowired
    private AppRep appRep;
    @Autowired
    private ItemRep itemRep;

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
        getNewItem(application);
        return appRep.save(application);
    }

    public Item getNewItem(Application application) {
        Item item = new Item();
        item.setName(application.getNameItem());
        item.setStatusItem(StatusItem.OnTheWay);
        item.setWeight(application.getWeightItem());
        item.setStartPoint(application.getStartPoint());
        itemRep.save(item);
        return item;
    }

    @Override
    public Application update(Application application) {
        return appRep.save(application);
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
