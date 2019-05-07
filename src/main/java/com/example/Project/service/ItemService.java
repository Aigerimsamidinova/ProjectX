package com.example.Project.service;

import com.example.Project.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItemsInOffice(Long id);
}
