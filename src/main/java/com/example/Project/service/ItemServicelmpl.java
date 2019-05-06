package com.example.Project.service;

import com.example.Project.model.Item;
import com.example.Project.repository.ItemRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServicelmpl implements CrudService<Item> {
    @Autowired
    private ItemRep itemRep;

    @Override
    public List<Item> getAll() {
        return itemRep.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRep.findById(id).get();
    }

    @Override
    public Item save(Item item) {
        return itemRep.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRep.save(item);
    }

    @Override
    public void deleteById(Long id) {
        itemRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
        itemRep.deleteAll();
    }
}
