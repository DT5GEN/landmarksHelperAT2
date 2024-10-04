package org.deeppowercrew.service;

import org.deeppowercrew.model.Landmark;
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
}