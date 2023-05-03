package org.example.controller;

import org.example.model.Abonament;
import org.example.model.AbonamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbonamentController {

    /*
        @RestController - dzięki tej adnotacji klasa staje się web servicem;
        adnotacja wymaga dependencji web i web serveces w mavenie
     */

    @Autowired
    private AbonamentRepository abonamentRepository;

    @PostMapping("/abonament")
    public int abonamentAdd(@RequestBody Abonament abonament) {
        Abonament savedAbonament = abonamentRepository.save(abonament);
        return savedAbonament.getId();
    }
}
