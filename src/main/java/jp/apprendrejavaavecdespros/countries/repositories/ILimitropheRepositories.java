package jp.apprendrejavaavecdespros.countries.repositories;

import jp.apprendrejavaavecdespros.countries.models.Limitrophe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILimitropheRepositories extends JpaRepository<Limitrophe,Long> {
    public List<Limitrophe> findByCountryName(String countryName);
}
