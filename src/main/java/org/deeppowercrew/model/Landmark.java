package org.deeppowercrew.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Temporal;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private LandmarkType type;

    @ManyToOne
    @JoinColumn(name = "locality_id")
    private Locality locality;

    @OneToMany(mappedBy = "attraction", cascade = CascadeType.ALL)
    private List<Landmark> landmarkList;
}