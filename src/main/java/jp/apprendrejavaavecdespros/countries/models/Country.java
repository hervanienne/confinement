package jp.apprendrejavaavecdespros.countries.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long countryId;

    private String countryName;

    private double superficie;

    private int numberCountryLimitrophes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent", referencedColumnName = "country_id")
    private List<Country> limitrophes;
}