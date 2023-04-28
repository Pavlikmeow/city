package com.test.city.service;

import com.test.city.exception.CityNotFoundException;
import com.test.city.mapper.CityMapper;
import com.test.city.repository.CityRepository;
import com.test.city.data.dto.CityDTO;
import com.test.city.data.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public void createNewCity(City city) {
        cityRepository.save(city);
    }

    public List<CityDTO> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::mapToCityDTO)
                .collect(Collectors.toList());
    }

    public City getCityById(UUID id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(
                        String.format("City with id: %s not found", id)
                ));
    }

    public CityDTO getCityDTOById(UUID id) {
        City city = getCityById(id);
        return cityMapper.mapToCityDTO(city);
    }

    public void deleteCityById(UUID id) {
        cityRepository.deleteById(id);
    }

    @Transactional
    public void changeCityNameById(UUID id, String newName) {
        City city = getCityById(id);
        city.setName(newName);
    }

}
