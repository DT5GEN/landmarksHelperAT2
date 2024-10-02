package org.deeppowercrew.model;

import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String region;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL)
    private List<Landmark> attractions;
}