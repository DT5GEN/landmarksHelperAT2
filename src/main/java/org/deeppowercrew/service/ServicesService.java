package org.deeppowercrew.service;

import org.deeppowercrew.model.Services;
import org.deeppowercrew.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    // Метод для добавления новой услуги
    public Services addServices(Services services) {
        return servicesRepository.save(services);
    }

    // Метод для получения всех услуг
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    // Метод для получения услуги по ID
    public Optional<Services> getServicesById(Long id) {
        return servicesRepository.findById(id);
    }

    // Метод для обновления услуги
    public Services updateServices(Long id, Services newServiceData) {
        return servicesRepository.findById(id)
                .map(existingService -> {
                    existingService.setName(newServiceData.getName());
                    existingService.setDescription(newServiceData.getDescription());
                    // Здесь можно обновить другие поля
                    return servicesRepository.save(existingService);
                })
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    // Метод для удаления услуги
    public void deleteServices(Long id) {
        servicesRepository.deleteById(id);
    }
}