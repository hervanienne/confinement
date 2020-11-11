package jp.apprendrejavaavecdespros.countries.services;

import jp.apprendrejavaavecdespros.countries.models.Country;
import jp.apprendrejavaavecdespros.countries.models.Limitrophe;
import jp.apprendrejavaavecdespros.countries.repositories.ICountryRepositories;
import jp.apprendrejavaavecdespros.countries.repositories.ILimitropheRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCountries implements IserviceCountries {

    @Autowired
    ICountryRepositories repositoryCountry;

    @Autowired
    ILimitropheRepositories repositoryLimitrophe;
    @Override
    public List<Country> getCountries() {
        return repositoryCountry.findAll();
    }

    @Override
    public List<Limitrophe> getCountriesLimitrophes(String countryName) {
        return repositoryLimitrophe.findByCountryName(countryName);
    }

}
