package jp.apprendrejavaavecdespros.countries.repositories;

import jp.apprendrejavaavecdespros.countries.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepositories extends JpaRepository<Country,Long> {
    @Query("Select c from Country c where c.countryName=?1")
    public Country getCountryByName(String countryName);
}
