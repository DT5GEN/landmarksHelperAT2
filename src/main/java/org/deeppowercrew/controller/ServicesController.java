package org.deeppowercrew.controller;

import org.deeppowercrew.dtos.ServicesDTO;
import org.deeppowercrew.model.Services;
import org.deeppowercrew.service.ServicesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public ServicesDTO addService(@RequestBody ServicesDTO servicesDTO) {
        Services service = servicesService.convertToEntity(servicesDTO);
        Services savedService = servicesService.addService(service);
        return servicesService.convertToDTO(savedService);
    }

    @GetMapping
    public List<ServicesDTO> getAllServices() {
        return servicesService.getAllServices().stream()
                .map(servicesService::convertToDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ServicesDTO updateService(@PathVariable Long id, @RequestBody ServicesDTO servicesDTO) {
        Services service = servicesService.convertToEntity(servicesDTO);
        Services updatedService = servicesService.updateService(id, service);
        return servicesService.convertToDTO(updatedService);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }
}
