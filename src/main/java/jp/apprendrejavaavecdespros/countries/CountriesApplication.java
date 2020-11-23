package jp.apprendrejavaavecdespros.countries;

import jp.apprendrejavaavecdespros.countries.models.Country;
import jp.apprendrejavaavecdespros.countries.repositories.ICountryRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CountriesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(CountriesApplication.class, args);

		ICountryRepositories countryRepository;

	}

}
