package org.deeppowercrew.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDTO {

    private Long id;
    private String type;
    private String description;
    private String performer;
    private List<Long> landmarkIds;
}
