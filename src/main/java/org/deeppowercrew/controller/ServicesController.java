package org.deeppowercrew.controller;

import org.deeppowercrew.dtos.ServicesDTO;
import org.deeppowercrew.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public ServicesDTO addService(@RequestBody ServicesDTO servicesDTO) {
        return servicesService.addService(servicesDTO);
    }

    @GetMapping
    public List<ServicesDTO> getAllServices() {
        return servicesService.getAllServices();
    }

    @PutMapping("/{id}")
    public ServicesDTO updateService(@PathVariable Long id, @RequestBody ServicesDTO servicesDTO) {
        return servicesService.updateService(id, servicesDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }
}
