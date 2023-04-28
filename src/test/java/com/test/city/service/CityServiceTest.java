package com.test.city.service;

import com.test.city.data.dto.CityDTO;
import com.test.city.data.entity.City;
import com.test.city.mapper.CityMapper;
import com.test.city.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Mock
    private CityMapper cityMapper;

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @Test
    public void testCreateNewCity() {
        City city = new City();
        cityService.createNewCity(city);
        Mockito.verify(cityRepository, times(1)).save(city);
    }

    @Test
    public void testGetAllCities() {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City());
        when(cityRepository.findAll()).thenReturn(cityList);

        List<CityDTO> cityDTOList = new ArrayList<>();
        cityDTOList.add(new CityDTO());
        when(cityMapper.mapToCityDTO(any(City.class))).thenReturn(new CityDTO());

        List<CityDTO> result = cityService.getAllCities();
        assertEquals(cityDTOList.size(), result.size());
    }

    @Test
    public void testGetCityById() {
        UUID id = UUID.randomUUID();
        City city = new City();
        when(cityRepository.findById(id)).thenReturn(Optional.of(city));

        City result = cityService.getCityById(id);
        assertEquals(city, result);
    }

    @Test
    public void testGetCityDTOById() {
        UUID id = UUID.randomUUID();
        City city = new City();
        when(cityRepository.findById(id)).thenReturn(Optional.of(city));

        CityDTO cityDTO = new CityDTO();
        when(cityMapper.mapToCityDTO(city)).thenReturn(cityDTO);

        CityDTO result = cityService.getCityDTOById(id);
        assertEquals(cityDTO, result);
    }

    @Test
    public void testDeleteCityById() {
        UUID id = UUID.randomUUID();
        cityService.deleteCityById(id);
        Mockito.verify(cityRepository, times(1)).deleteById(id);
    }

    @Test
    public void testChangeCityNameById() {
        UUID id = UUID.randomUUID();
        String newName = "New City Name";
        City city = new City();
        when(cityRepository.findById(id)).thenReturn(Optional.of(city));

        cityService.changeCityNameById(id, newName);
        assertEquals(newName, city.getName());
    }
}
