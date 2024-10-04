package org.deeppowercrew.service;

import org.deeppowercrew.model.Locality;
import org.deeppowercrew.repository.LocalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalityService {

    private final LocalityRepository localityRepository;

    public LocalityService(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    public Locality addLocality(Locality locality) {
        return localityRepository.save(locality);
    }

    public List<Locality> getAllLocalities() {
        return localityRepository.findAll();
    }

    public Optional<Locality> getLocalityById(Long id) {
        return localityRepository.findById(id);
    }

    public void deleteLocality(Long id) {
        localityRepository.deleteById(id);
    }

    public Locality updateLocality(Long id, Locality updatedLocality) {
        Optional<Locality> existingLocality = localityRepository.findById(id);
        if (existingLocality.isPresent()) {
            Locality locality = existingLocality.get();
            locality.setCity(updatedLocality.getCity());
            locality.setRegion(updatedLocality.getRegion());
            locality.setLatitude(updatedLocality.getLatitude());
            locality.setLongitude(updatedLocality.getLongitude());
            return localityRepository.save(locality);
        } else {
            throw new RuntimeException("Locality not found");
        }
    }
}