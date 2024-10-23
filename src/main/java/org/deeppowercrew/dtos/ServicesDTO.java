package org.deeppowercrew.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicesDTO {
    private Long id;
    private String name;
    private String provider;
    private String description;
    private int rating;
    private String type;
}