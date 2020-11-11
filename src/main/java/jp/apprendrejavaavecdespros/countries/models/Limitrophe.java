package jp.apprendrejavaavecdespros.countries.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="LIMITROPHE")
public class Limitrophe{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long limitropheId;
    private String countryName;
    private String limitropheName;
}
