package com.example.Project.service;

import com.example.Project.model.Client;
import com.example.Project.repository.ClientRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements CrudService<Client>{
    @Autowired
    private ClientRep clientRep;

    @Override
    public List<Client> getAll() {
        return clientRep.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRep.findById(id).get();
    }

    @Override
    public Client save(Client client) {
        return clientRep.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRep.save(client);
    }

    @Override
    public void deleteById(Long id) {
        clientRep.deleteById(id);
    }

    @Override
    public void deleteAll() {

    }
}
