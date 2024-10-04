package org.deeppowercrew.controller;

import org.deeppowercrew.dtos.LandmarkDTO;
import org.deeppowercrew.model.Landmark;
import org.deeppowercrew.service.LandmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LandmarkController {

    private final LandmarkService landmarkService;

    public LandmarkController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }

    @PostMapping("/landmark")
    public Landmark addLandmark(@RequestBody Landmark landmark) {
        return landmarkService.addLandmark(landmark);
    }

    @GetMapping("/landmark")
    public List<LandmarkDTO> getAllLandmarks() {
        return landmarkService.getAllLandmarks()
                .stream()
                .map(landmarkService::convertToDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Landmark getLandmarkById(@PathVariable Long id) {
        return landmarkService.getLandmarkById(id)
                .orElseThrow(() -> new RuntimeException("Landmark not found"));
    }

    @PutMapping("/{id}")
    public Landmark updateLandmark(@PathVariable Long id, @RequestBody Landmark landmark) {
        return landmarkService.updateLandmark(id, landmark);
    }

    @DeleteMapping("/{id}")
    public void deleteLandmark(@PathVariable Long id) {
        landmarkService.deleteLandmark(id);
    }
}