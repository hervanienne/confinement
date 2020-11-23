package jp.apprendrejavaavecdespros.countries.controllers;

import jp.apprendrejavaavecdespros.countries.models.Country;
import jp.apprendrejavaavecdespros.countries.services.IserviceCountries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControllerCountries {

    @Autowired
    private IserviceCountries service;

    @GetMapping(path="/countries")
    public String init(Model model){

        List countries = service.getCountries()
                .stream()
                .map(Country :: getCountryName)
                .collect(Collectors.toList());

        FillCountryLimitrophes(countries);
        model.addAttribute("liste",countries);

        return "index";
    }

    @GetMapping(path="/limitrophes/{country}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<String> getLimitrophes(@PathVariable String country, Model model){
        List limitrophes  = new ArrayList();
        limitrophes  =service.getCountryByName(country)
                      .getLimitrophes()
                      .stream()
                      .map(Country :: getCountryName)
                      .collect(Collectors.toList());
        model.addAttribute("liste",limitrophes);
        return limitrophes;
    }

    void FillCountryLimitrophes(List<String> countries){
        Country parent1 = service.getCountryByName("France");
        Country parent2 = service.getCountryByName("Allemagne");
        Country parent3 = service.getCountryByName("Italie");
        Country parent4 = service.getCountryByName("Suisse");

        parent1.setLimitrophes(
                new ArrayList<>(){
                    {
                        add(service.getCountryByName("Allemagne"));
                        add(service.getCountryByName("Andorre"));
                        add(service.getCountryByName("Belgique"));
                        add(service.getCountryByName("Brésil"));
                        add(service.getCountryByName("Espagne"));
                        add(service.getCountryByName("Italie"));
                        add(service.getCountryByName("Luxembourg"));
                        add(service.getCountryByName("Monaco"));
                        add(service.getCountryByName("Pays-Bas"));
                        add(service.getCountryByName("Suisse"));
                        add(service.getCountryByName("Suriname"));
                    }
                }
        );

        parent2.setLimitrophes(
                new ArrayList<>(){
                    {
                        add(service.getCountryByName("Autriche"));
                        add(service.getCountryByName("Belgique"));
                        add(service.getCountryByName("Danemark"));
                        add(service.getCountryByName("France"));
                        add(service.getCountryByName("Luxembourg"));
                        add(service.getCountryByName("Pays-Bas"));
                        add(service.getCountryByName("Pologne"));
                        add(service.getCountryByName("République Tchèque"));
                        add(service.getCountryByName("Suisse"));
                    }
                }
        );

        parent3.setLimitrophes(
                new ArrayList<>(){
                    {
                        add(service.getCountryByName("Autriche"));
                        add(service.getCountryByName("France"));
                        add(service.getCountryByName("Saint-Martin"));
                        add(service.getCountryByName("Slovénie"));
                        add(service.getCountryByName("Suisse"));
                        add(service.getCountryByName("Vatican"));
                    }
                }
        );

        parent4.setLimitrophes(
                new ArrayList<>(){
                    {
                        add(service.getCountryByName("Allemagne"));
                        add(service.getCountryByName("Autriche"));
                        add(service.getCountryByName("France"));
                        add(service.getCountryByName("Italie"));
                        add(service.getCountryByName("Liechtensein"));
                    }
                }
        );
        service.save(parent1);
        service.save(parent2);
        service.save(parent3);
        service.save(parent4);
    }
}
