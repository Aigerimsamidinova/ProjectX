package com.example.Project.controller;

import com.example.Project.model.Client;
import com.example.Project.service.CrudService;
import com.example.Project.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private CrudService<Client> clientCrudService;

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response add(@RequestBody Client c) {
        return new Response("Created new Client", true, clientCrudService.save(c));
    }

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Client> getAll() {
        return clientCrudService.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable Long id) {
        return new Response("Client by id: " + id, true, clientCrudService.findById(id));
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response delete(@PathVariable Long id) {
        clientCrudService.deleteById(id);
        try {
            return new Response("Delete client by id: " + id, true, null);
        } catch (Exception ex) {
            return new Response(ex.getMessage(), false, null);
        }
    }
}
