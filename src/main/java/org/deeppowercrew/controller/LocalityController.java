package org.deeppowercrew.controller;

import org.deeppowercrew.dtos.LocalityDTO;
import org.deeppowercrew.service.LocalityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/localities")
public class LocalityController {

    private final LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping
    public List<LocalityDTO> getAllLocalities() {
        return localityService.getAllLocalities();
    }
}
