package org.deeppowercrew.controller;

import org.deeppowercrew.dtos.LandmarkDTO;
import org.deeppowercrew.model.Landmark;
import org.deeppowercrew.service.LandmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/landmarks")

public class LandmarkController {

    private final LandmarkService landmarkService;

    public LandmarkController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }

    @PostMapping
    public LandmarkDTO addLandmark(@RequestBody LandmarkDTO landmarkDTO) {
        Landmark landmark = landmarkService.convertToEntity(landmarkDTO);
        Landmark savedLandmark = landmarkService.addLandmark(landmark);
        return landmarkService.convertToDTO(savedLandmark);
    }

    @GetMapping
    public List<LandmarkDTO> getAllLandmarks() {
        return landmarkService.getAllLandmarks().stream()
                .map(landmarkService::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LandmarkDTO getLandmarkById(@PathVariable Long id) {
        Landmark landmark = landmarkService.getLandmarkById(id)
                .orElseThrow(() -> new RuntimeException("Landmark not found"));
        return landmarkService.convertToDTO(landmark);
    }

    @PutMapping("/{id}")
    public LandmarkDTO updateLandmark(@PathVariable Long id, @RequestBody LandmarkDTO landmarkDTO) {
        Landmark landmark = landmarkService.convertToEntity(landmarkDTO);
        Landmark updatedLandmark = landmarkService.updateLandmark(id, landmark);
        return landmarkService.convertToDTO(updatedLandmark);
    }

    @DeleteMapping("/{id}")
    public void deleteLandmark(@PathVariable Long id) {
        landmarkService.deleteLandmark(id);
    }
}
