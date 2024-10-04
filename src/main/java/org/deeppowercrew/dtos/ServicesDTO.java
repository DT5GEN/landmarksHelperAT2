package org.deeppowercrew.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicesDTO {
    private Long id;
    private String name;
    private String description;
    private String provider;
    private String type;
}