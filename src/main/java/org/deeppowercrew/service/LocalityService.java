package org.deeppowercrew.service;


import org.deeppowercrew.dtos.LocalityDTO;
import org.deeppowercrew.model.Landmark;
import org.deeppowercrew.model.Locality;
import org.deeppowercrew.repository.LocalityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalityService {

    private final LocalityRepository localityRepository;

    public LocalityService(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }
    @Transactional(readOnly = true)
    public List<LocalityDTO> getAllLocalities() {
        return localityRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private LocalityDTO convertToDTO(Locality locality) {
        LocalityDTO dto = new LocalityDTO();
        dto.setId(locality.getId());
        dto.setName(locality.getName());
        dto.setDescription(locality.getDescription());
        dto.setLatitude(locality.getLatitude());
        dto.setLongitude(locality.getLongitude());
        dto.setLandmarkIds(locality.getLandmarks()
                .stream()
                .map(Landmark::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
