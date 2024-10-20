package org.deeppowercrew.service;

import lombok.RequiredArgsConstructor;
import org.deeppowercrew.dtos.ServicesDTO;
import org.deeppowercrew.model.Landmark;
import org.deeppowercrew.model.ServiceType;
import org.deeppowercrew.model.Services;
import org.deeppowercrew.repository.LandmarkRepository;
import org.deeppowercrew.repository.ServicesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicesService {

    private final ServicesRepository servicesRepository;
    private final LandmarkRepository landmarkRepository;

    public ServicesDTO addService(ServicesDTO dto) {
        Services service = convertToEntity(dto);
        Services savedService = servicesRepository.save(service);
        return convertToDTO(savedService);
    }
    @Transactional(readOnly = true)
    public List<ServicesDTO> getAllServices() {
        return servicesRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ServicesDTO updateService(Long id, ServicesDTO dto) {
        Services service = servicesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        service.setType(ServiceType.valueOf(dto.getType()));
        service.setDescription(dto.getDescription());
        service.setPerformer(dto.getPerformer());
        service.setLandmarks(landmarkRepository.findAllById(dto.getLandmarkIds()));
        return convertToDTO(servicesRepository.save(service));
    }

    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }

    private ServicesDTO convertToDTO(Services service) {
        List<Long> landmarkIds = service.getLandmarks().stream()
                .map(Landmark::getId)
                .collect(Collectors.toList());
        return ServicesDTO.builder()
                .id(service.getId())
                .type(service.getType().name())
                .description(service.getDescription())
                .performer(service.getPerformer())
                .landmarkIds(landmarkIds)
                .build();
    }

    private Services convertToEntity(ServicesDTO dto) {
        List<Landmark> landmarks = landmarkRepository.findAllById(dto.getLandmarkIds());
        return Services.builder()
                .type(ServiceType.valueOf(dto.getType()))
                .description(dto.getDescription())
                .performer(dto.getPerformer())
                .landmarks(landmarks)
                .build();
    }
}
