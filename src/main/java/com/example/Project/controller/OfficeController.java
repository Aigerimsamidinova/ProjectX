package com.example.Project.controller;

import com.example.Project.model.Office;
import com.example.Project.service.CrudService;
import com.example.Project.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private CrudService<Office> officeCrudService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Office> getAll() {
        return officeCrudService.getAll();
    }

    @GetMapping(path = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response getById(@PathVariable Long id) {
        try {
            return new Response("Office by id = " + id, true, officeCrudService.findById(id));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @PostMapping(path = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response add(@RequestBody Office o) {
        try {
            return new Response("Successfully created", true, officeCrudService.save(o));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @PutMapping(path = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response updateOffice(Office office) {
        try {
            return new Response("Updated", true, officeCrudService.update(office));
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response deleteById(@PathVariable Long id) {
        try {
            officeCrudService.deleteById(id);
            return new Response("Deleted office by id = " + id, true, null);
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }

    @DeleteMapping(path = "/deleteAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private Response deleteAll() {
        try {
            officeCrudService.deleteAll();
            return new Response("Deleted all offices", true, null);
        } catch (Exception e) {
            return new Response(e.toString(), false, null);
        }
    }
}