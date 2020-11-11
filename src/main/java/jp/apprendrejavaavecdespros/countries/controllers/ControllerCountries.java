package jp.apprendrejavaavecdespros.countries.controllers;

import jp.apprendrejavaavecdespros.countries.models.Country;
import jp.apprendrejavaavecdespros.countries.models.Limitrophe;
import jp.apprendrejavaavecdespros.countries.services.IserviceCountries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServlet;
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
        model.addAttribute("liste",countries);

        return "index";
    }

    @GetMapping(path="/limitrophes/{countryName}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<String> getCountryLimitByCountry(@PathVariable String countryName, Model model){
        List limitrophes = service.getCountriesLimitrophes(countryName)
                .stream()
                .map(Limitrophe :: getLimitropheName)
                .collect(Collectors.toList());
        model.addAttribute("limitrophes",limitrophes);
        return limitrophes;
    }
}
