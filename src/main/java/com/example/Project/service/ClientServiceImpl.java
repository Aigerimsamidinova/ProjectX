package com.example.Project.service;

import com.example.Project.enums.StatusItem;
import com.example.Project.model.Client;
import com.example.Project.model.Item;
import com.example.Project.model.Office;
import com.example.Project.repository.ClientRep;
import com.example.Project.repository.ItemRep;
import com.example.Project.repository.OfficeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements CrudService<Client>, ClientService {
    @Autowired
    private ClientRep clientRep;
    @Autowired
    private OfficeRep officeRep;
    @Autowired
    private ItemRep itemRep;

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
        clientRep.deleteAll();
    }

    @Override
    public Client bookItem(Long itemId, Long officeId, Client c) {
        Client client = getClient(c);
        Item item = getItem(itemId);
        Office office = getOffice(officeId);
        List<Item> items = office.getItems();
        List<Item> clientItems = new ArrayList<>();
        for (Item it : items) {
            if (it.getId().equals(itemId)) {
                item.setStatusItem(StatusItem.TakenAway);
                clientItems.add(it);
                items.remove(it);
            }
        }
        client.setItems(clientItems);
        office.setItems(items);
        itemRep.save(item);
        officeRep.save(office);
        clientRep.save(client);
        return client;
    }
    public Office getOffice(Long officeId) {
        Office office = officeRep.findById(officeId).get();
        return office;
    }

    public Item getItem(Long itemId) {
        Item item = itemRep.findById(itemId).get();
        return item;
    }

    public Client getClient(Client client) {
        Client client1 = new Client();
        client1.setFio(client.getFio());
        client1.setNumber(client.getNumber());
        return client1;
    }
}
