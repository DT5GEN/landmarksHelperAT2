package org.deeppowercrew.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "locality")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Locality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String region;
    private Double latitude;
    private Double longitude;
    private String description;

    @OneToMany(mappedBy = "locality")
    private List<Landmark> landmarks;
}
