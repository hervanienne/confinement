package jp.apprendrejavaavecdespros.countries.services;


import jp.apprendrejavaavecdespros.countries.models.Country;
import jp.apprendrejavaavecdespros.countries.models.Limitrophe;

import java.util.List;

public interface IserviceCountries {
    public List<Country> getCountries();
    public List<Limitrophe> getCountriesLimitrophes(String countryName);
}
