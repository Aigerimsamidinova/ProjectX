package com.example.Project.controller;

import com.example.Project.enums.StatusApp;
import com.example.Project.model.Application;
import com.example.Project.model.Courier;
import com.example.Project.service.CourierService;
import com.example.Project.service.CrudService;
import com.example.Project.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {
    @Autowired
    private CrudService<Courier> courierCrudService;

    @Autowired
    private CourierService courierService;

    @Autowired
    private CrudService<Application> applicationCrudService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Courier> getAll() {
        return courierCrudService.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable Long id) {
        try {
            return new Response("Courier by id = " + id, true, courierCrudService.findById(id));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response add(@RequestBody Courier courier) {
        try {
            return new Response("Successfully created", true, courierCrudService.save(courier));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }
 @PostMapping(path = "/change/{courierId}/{appId}/{code}",
         produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response changeAppStatus(@RequestBody Courier courier,
                                    @PathVariable Long courierId,
                                    @PathVariable Long appId,
                                    @PathVariable String code) {
     Application application = courierService.changeApplicationStatus(courierId,appId, code);
        try {
            return new Response("Successfully changed", true, application);
        } catch (Exception e) {
            application.setStatusApp(StatusApp.ERROR);
            applicationCrudService.update(application);
            return new Response(e.toString(), false, null);
        }
    }

    @PutMapping(path = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response updateOffice(Courier courier) {
        try {
            return new Response("Updated", true, courierCrudService.update(courier));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteById(@PathVariable Long id) {
        try {
            courierCrudService.deleteById(id);
            return new Response("Deleted courier by id = " + id, true, null);
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @DeleteMapping(path = "/deleteAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response deleteAll() {
        try {
            courierCrudService.deleteAll();
            return new Response("Deleted all couriers", true, null);
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }
}