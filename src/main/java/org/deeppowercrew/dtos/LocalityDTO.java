package org.deeppowercrew.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class LocalityDTO {
    private Long id;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private List<Long> landmarkIds;
}
