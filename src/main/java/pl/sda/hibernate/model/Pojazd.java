package pl.sda.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Pojazd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marka;
    private String model;
    private String vin;
    private String nrRej;

    @OneToMany(mappedBy = "pojazd")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<SerwisPojazdu> serwisy;

}

