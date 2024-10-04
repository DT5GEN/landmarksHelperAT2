package org.deeppowercrew.controller;

import org.deeppowercrew.dtos.ServicesDTO;
import org.deeppowercrew.model.Services;
import org.deeppowercrew.service.ServicesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/services")
    public List<ServicesDTO> getAllServices() {
        return servicesService.getAllServices()
                .stream()
                .map(servicesService::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/service")
    public ServicesDTO addService(@RequestBody ServicesDTO serviceDTO) {
        Services service = servicesService.convertFromDTO(serviceDTO);
        return servicesService.convertToDTO(servicesService.addServices(service));
    }

    @GetMapping("/{id}")
    public Services getServicesById(@PathVariable Long id) {
        return servicesService.getServicesById(id).orElseThrow(() -> new RuntimeException("Services not found"));
    }

    @PutMapping("/{id}")
    public Services updateServices(@PathVariable Long id, @RequestBody Services services) {
        return servicesService.updateServices(id, services);
    }

    @DeleteMapping("/{id}")
    public void deleteServices(@PathVariable Long id) {
        servicesService.deleteServices(id);
    }
}