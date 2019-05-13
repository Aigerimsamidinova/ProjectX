package com.example.Project.controller;

import com.example.Project.enums.Pointer;
import com.example.Project.enums.StatusApp;
import com.example.Project.model.Application;
import com.example.Project.model.Courier;
import com.example.Project.service.CrudService;
import com.example.Project.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private CrudService<Application> appServise;

    @Autowired
    private CrudService<Courier> courierCrudService;

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
    public Response add(@RequestBody Application application) {
        Application application1 = this.appServise.save(application);
        Long id1 = new Long("1");
        Long id2 = new Long("2");
        Courier courier1 = courierCrudService.findById(id1);
        Courier courier2 = courierCrudService.findById(id2);
        try {
            if(application.getStartPoint().equals(Pointer.BISHKEK)){
                return new Response("Ожидайте курьера", true, courierCrudService.findById(courier1.getId()));
            }
            else {
                return new Response("Ожидайте курьера", true, courierCrudService.findById(courier2.getId()));
            }
        } catch (Exception e) {
            application1.setStatusApp(StatusApp.ERROR);
            appServise.update(application1);
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