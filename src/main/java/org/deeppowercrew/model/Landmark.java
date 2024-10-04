package org.deeppowercrew.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "landmark")
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

    // Рекурсивная связь: родительский объект Landmark
    @ManyToOne
    @JoinColumn(name = "parent_landmark_id")
    private Landmark parentLandmark;

    // Список дочерних объектов Landmark
    @OneToMany(mappedBy = "parentLandmark", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Landmark> landmarkList;
}