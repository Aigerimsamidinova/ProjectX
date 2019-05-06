package com.example.Project.bootstrap;

import com.example.Project.enums.Pointer;
import com.example.Project.model.Application;
import com.example.Project.model.Office;
import com.example.Project.repository.AppRep;
import com.example.Project.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private AppRep appRep;

    @Autowired
    private CrudService<Office> officeCrudService;

    @Override
    public void run(String... args) throws Exception {
        Application application = new Application.Builder("222","Gogolya 112-8", Pointer.BISHKEK)
                .withEndPoint(Pointer.OSH)
                .withFio("Kanat Subanov")
                .withnameItem("Konvert")
                .withWeightItem(0.01)
                .build();
        appRep.save(application);

        Office office1 = new Office.Builder(Pointer.BISHKEK).build();
        officeCrudService.save(office1);

        Office office2 = new Office.Builder(Pointer.OSH).build();
        officeCrudService.save(office2);
    }
}
