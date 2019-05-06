package com.example.Project.controller;

import com.example.Project.model.Application;
import com.example.Project.service.CrudService;
import com.example.Project.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppController.URL_APPLICATION)
public class AppController {
    public final static String URL_APPLICATION = "/spring/app";
    @Autowired
    private CrudService<Application> appServise;
    
    
    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Application> getAll() {
        return appServise.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable Long id) {
        try {
            return new Response("Application by id = " + id, true, appServise.findById(id));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response add(@RequestBody Application c) {
        try {
            return new Response("Successfully created", true, appServise.save(c));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @PutMapping(path = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response updateItem(Application Application) {
        try {
            return new Response("Updated", true, appServise.update(Application));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteById(@PathVariable Long id) {
        try {
            appServise.deleteById(id);
            return new Response("Deleted Application by id = " + id, true, null);
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @DeleteMapping(path = "/deleteAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response deleteAll() {
        try {
            appServise.deleteAll();
            return new Response("Deleted all Applications", true, null);
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }
}