package org.deeppowercrew.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LocalityDTO {
    private Long id;
    private String city;
    private String region;
    private Double latitude;
    private Double longitude;
}
