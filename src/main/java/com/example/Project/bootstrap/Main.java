package com.example.Project.bootstrap;

import com.example.Project.enums.Pointer;
import com.example.Project.model.Application;
import com.example.Project.model.Courier;
import com.example.Project.model.Office;
import com.example.Project.repository.AppRep;
import com.example.Project.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private CrudService<Application> applicationCrudService;

    @Autowired
    private CrudService<Office> officeCrudService;

    @Autowired
    private CrudService<Courier> courierCrudService;

    @Override
    public void run(String... args) throws Exception {
//        Application application = new Application.Builder("222","Gogolya 112-8", Pointer.BISHKEK)
//                .withEndPoint(Pointer.OSH)
//                .withFio("Kanat Subanov")
//                .withnameItem("Konvert")
//                .withWeightItem(0.01)
//                .build();
//        applicationCrudService.save(application);

        Courier courier1 = new Courier.Builder(Pointer.BISHKEK)
                .withEmail("kumarsamiev@gmail.com")
                .withFio("Samiev Kumar").withPhone("777").build();
        courierCrudService.save(courier1);

        Courier courier2 = new Courier.Builder(Pointer.OSH)
                .withEmail("kanatsubanov@gmail.com")
                .withFio("Subanov Kanat").withPhone("222").build();
        courierCrudService.save(courier2);

        Office office1 = new Office.Builder(Pointer.BISHKEK).build();
        officeCrudService.save(office1);

        Office office2 = new Office.Builder(Pointer.OSH).build();
        officeCrudService.save(office2);
    }
}
