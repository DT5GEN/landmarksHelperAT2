package org.deeppowercrew.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LandmarkDTO {
    private Long id;
    private String name;
    private String description;
    private String creationDate;
    private String type;
    private org.deeppowercrew.dtos.LocalityDTO locality;
    private LandmarkDTO parentLandmark;
}