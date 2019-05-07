package com.example.Project.service;

import com.example.Project.model.Client;

public interface ClientService {
    Client bookItem(Long itemId, Long officeId, Client c);
}
