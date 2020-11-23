package jp.apprendrejavaavecdespros.countries.services;


import jp.apprendrejavaavecdespros.countries.models.Country;

import java.util.List;

public interface IserviceCountries {
    public List<Country> getCountries();

    public Country getCountryByName(String countryName);

    void save(Country count1);
}
