package jp.apprendrejavaavecdespros.countries.services;

import jp.apprendrejavaavecdespros.countries.models.Country;
import jp.apprendrejavaavecdespros.countries.repositories.ICountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCountries implements IserviceCountries {

    @Autowired
    ICountryRepositories repositoryCountry;

    @Override
    public List<Country> getCountries() {
        return repositoryCountry.findAll();
    }


    @Override
    public Country getCountryByName(String countryName) {
        return repositoryCountry.getCountryByName(countryName);
    }

    @Override
    public void save(Country count1) {
        repositoryCountry.save(count1);
    }

}
