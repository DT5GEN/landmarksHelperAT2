package org.deeppowercrew.controller;

import org.deeppowercrew.model.Locality;
import org.deeppowercrew.service.LocalityService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/localities")
public class LocalityController {

    private final LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    @PostMapping
    public Locality addLocality(@RequestBody Locality locality) {
        return localityService.addLocality(locality);
    }

    @GetMapping
    public List<Locality> getAllLocalities() {
        return localityService.getAllLocalities();
    }

    @GetMapping("/{id}")
    public Locality getLocalityById(@PathVariable Long id) {
        return localityService.getLocalityById(id).orElseThrow(() -> new RuntimeException("Locality not found"));
    }

    @PutMapping("/{id}")
    public Locality updateLocality(@PathVariable Long id, @RequestBody Locality locality) {
        return localityService.updateLocality(id, locality);
    }

    @DeleteMapping("/{id}")
    public void deleteLocality(@PathVariable Long id) {
        localityService.deleteLocality(id);
    }
}