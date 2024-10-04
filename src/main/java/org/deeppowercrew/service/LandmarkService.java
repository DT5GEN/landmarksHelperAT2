package org.deeppowercrew.service;

import org.deeppowercrew.dtos.LandmarkDTO;
import org.deeppowercrew.dtos.LocalityDTO;
import org.deeppowercrew.model.Landmark;
import org.deeppowercrew.model.Locality;
import org.deeppowercrew.repository.LandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;

    @Autowired
    public LandmarkService(LandmarkRepository landmarkRepository) {
        this.landmarkRepository = landmarkRepository;
    }

    // Метод для добавления новой достопримечательности
    public Landmark addLandmark(Landmark landmark) {
        return landmarkRepository.save(landmark);
    }

    // Метод для получения всех достопримечательностей
    public List<Landmark> getAllLandmarks() {
        return landmarkRepository.findAll();
    }

    // Метод для получения достопримечательности по ID
    public Optional<Landmark> getLandmarkById(Long id) {
        return landmarkRepository.findById(id);
    }

    // Метод для обновления достопримечательности
    public Landmark updateLandmark(Long id, Landmark newLandmarkData) {
        return landmarkRepository.findById(id)
                .map(existingLandmark -> {
                    existingLandmark.setName(newLandmarkData.getName());
                    existingLandmark.setDescription(newLandmarkData.getDescription());
                    // Обновление других полей
                    return landmarkRepository.save(existingLandmark);
                })
                .orElseThrow(() -> new RuntimeException("Landmark not found"));
    }

    // Метод для удаления достопримечательности
    public void deleteLandmark(Long id) {
        landmarkRepository.deleteById(id);
    }

    public LandmarkDTO convertToDTO(Landmark landmark) {
        LandmarkDTO dto = new LandmarkDTO();
        dto.setId(landmark.getId());
        dto.setName(landmark.getName());
        dto.setDescription(landmark.getDescription());
        dto.setCreationDate(landmark.getCreationDate().toString());
        dto.setType(landmark.getType() != null ? landmark.getType().name() : null);
        dto.setLocality(landmark.getLocality() != null ? convertLocalityToDTO(landmark.getLocality()) : null);
        dto.setParentLandmark(landmark.getParentLandmark() != null ? convertToDTO(landmark.getParentLandmark()) : null);
        return dto;
    }

    private LocalityDTO convertLocalityToDTO(Locality locality) {
        LocalityDTO dto = new LocalityDTO();
        dto.setId(locality.getId());
        dto.setCity(locality.getCity());
        dto.setRegion(locality.getRegion());
        dto.setLatitude(locality.getLatitude());
        dto.setLongitude(locality.getLongitude());
        return dto;
    }
}