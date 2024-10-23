package org.deeppowercrew.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locality")
public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String country;


    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL)
    private List<Landmark> landmarks;
}
