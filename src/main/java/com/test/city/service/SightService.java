package com.test.city.service;

import com.test.city.data.dto.CreateSightRequest;
import com.test.city.data.dto.SightDTO;
import com.test.city.data.entity.City;
import com.test.city.data.entity.Sight;
import com.test.city.exception.SightNotFoundException;
import com.test.city.mapper.SightMapper;
import com.test.city.repository.SightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SightService {

    private final SightRepository sightRepository;
    private final SightMapper sightMapper;
    private final CityService cityService;

    public void createNewSight(CreateSightRequest createSightRequest) {
        UUID cityId = createSightRequest.getCityId();
        City city = cityService.getCityById(cityId);

        Sight sight = sightMapper.mapToSight(createSightRequest);
        sight.setCity(city);
        sightRepository.save(sight);
    }

    public List<SightDTO> getAllSights() {
        return sightRepository.findAll()
                .stream()
                .map(sightMapper::mapToSightDTO)
                .collect(Collectors.toList());
    }

    public Sight getSightById(UUID id) {
        return sightRepository.findById(id)
                .orElseThrow(() -> new SightNotFoundException(
                        String.format("Sight with id: %s not found", id)
                ));
    }

    public SightDTO getSightDTOById(UUID id) {
        Sight sight = getSightById(id);
        return sightMapper.mapToSightDTO(sight);
    }

    public void deleteSightById(UUID id) {
        sightRepository.deleteById(id);
    }

    @Transactional
    public void changeSightNameById(UUID id, String newName) {
        Sight sight = getSightById(id);
        sight.setName(newName);
    }

}