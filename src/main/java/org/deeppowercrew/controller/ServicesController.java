package org.deeppowercrew.controller;

import org.deeppowercrew.model.Services;
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
    public Services addServices(@RequestBody Services services) {
        return servicesService.addServices(services);
    }

    @GetMapping
    public List<Services> getAllServices() {
        return servicesService.getAllServices();
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