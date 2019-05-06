package com.example.Project.service;

import com.example.Project.enums.StatusItem;
import com.example.Project.model.Item;
import com.example.Project.model.Office;
import com.example.Project.repository.ItemRep;
import com.example.Project.repository.OfficeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServicelmpl implements CrudService<Office>, OfficeService {
    @Autowired
    private OfficeRep officeRep;

    @Autowired
    private ItemRep itemRep;


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

    @Override
    public Office addItem(Long id, Long itemId) {
        Office office = officeRep.findById(id).get();
        List<Item> items = office.getItems();
        Item item = itemRep.findById(itemId).get();
        if (item.getStartPoint().equals(office.getAddress())) {
            item.setStatusItem(StatusItem.InTheOffice);
            itemRep.save(item);
            items.add(item);
        }
        office.setItems(items);
        officeRep.save(office);
        return office;
    }
}
