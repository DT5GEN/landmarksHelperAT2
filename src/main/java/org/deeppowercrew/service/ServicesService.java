package org.deeppowercrew.service;

import org.deeppowercrew.dtos.ServicesDTO;
import org.deeppowercrew.model.Services;
import org.deeppowercrew.repository.ServicesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicesService {

    private final ServicesRepository servicesRepository;
    private final ModelMapper modelMapper;

    public ServicesService(ServicesRepository servicesRepository, ModelMapper modelMapper) {
        this.servicesRepository = servicesRepository;
        this.modelMapper = modelMapper;
    }

    public Services addService(Services service) {
        return servicesRepository.save(service);
    }

    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Optional<Services> getServiceById(Long id) {
        return servicesRepository.findById(id);
    }

    public Services updateService(Long id, Services updatedService) {
        Optional<Services> existingService = servicesRepository.findById(id);
        if (existingService.isPresent()) {
            updatedService.setId(id);
            return servicesRepository.save(updatedService);
        } else {
            throw new RuntimeException("Service not found");
        }
    }

    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }

    public Services convertToEntity(ServicesDTO servicesDTO) {
        return modelMapper.map(servicesDTO, Services.class);
    }

    public ServicesDTO convertToDTO(Services service) {
        return modelMapper.map(service, ServicesDTO.class);
    }
}
