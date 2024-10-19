package org.deeppowercrew.service;

import org.deeppowercrew.dtos.LandmarkDTO;
import org.deeppowercrew.model.Landmark;
import org.deeppowercrew.repository.LandmarkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;
    private final ModelMapper modelMapper;

    public LandmarkService(LandmarkRepository landmarkRepository, ModelMapper modelMapper) {
        this.landmarkRepository = landmarkRepository;
        this.modelMapper = modelMapper;
    }

    public Landmark addLandmark(Landmark landmark) {
        return landmarkRepository.save(landmark);
    }

    public List<Landmark> getAllLandmarks() {
        return landmarkRepository.findAll();
    }

    public Optional<Landmark> getLandmarkById(Long id) {
        return landmarkRepository.findById(id);
    }

    public Landmark updateLandmark(Long id, Landmark landmark) {
        landmark.setId(id); // Устанавливаем ID перед обновлением
        return landmarkRepository.save(landmark);
    }

    public void deleteLandmark(Long id) {
        landmarkRepository.deleteById(id);
    }

    public Landmark convertToEntity(LandmarkDTO landmarkDTO) {
        return modelMapper.map(landmarkDTO, Landmark.class);
    }

    public LandmarkDTO convertToDTO(Landmark landmark) {
        return modelMapper.map(landmark, LandmarkDTO.class);
    }
}
