package com.test.city.service;

import com.test.city.data.dto.CreateSightRequest;
import com.test.city.data.dto.SightDTO;
import com.test.city.data.entity.City;
import com.test.city.data.entity.Sight;
import com.test.city.mapper.SightMapper;
import com.test.city.repository.SightRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SightServiceTest {

    @Mock
    private SightRepository sightRepository;

    @Mock
    private SightMapper sightMapper;

    @Mock
    private CityService cityService;

    @InjectMocks
    private SightService sightService;

    @Test
    public void testCreateNewSight() {
        UUID cityId = UUID.randomUUID();
        City city = new City();
        CreateSightRequest createSightRequest = new CreateSightRequest();
        createSightRequest.setCityId(cityId);

        when(cityService.getCityById(cityId)).thenReturn(city);

        Sight sight = new Sight();
        when(sightMapper.mapToSight(createSightRequest)).thenReturn(sight);

        sightService.createNewSight(createSightRequest);
        Mockito.verify(sightRepository, Mockito.times(1)).save(sight);
    }

    @Test
    public void testGetAllSights() {
        List<Sight> sightList = new ArrayList<>();
        sightList.add(new Sight());
        when(sightRepository.findAll()).thenReturn(sightList);

        List<SightDTO> sightDTOList = new ArrayList<>();
        sightDTOList.add(new SightDTO());
        when(sightMapper.mapToSightDTO(any(Sight.class))).thenReturn(new SightDTO());

        List<SightDTO> result = sightService.getAllSights();
        assertEquals(sightDTOList.size(), result.size());
    }

    @Test
    public void testGetSightById() {
        UUID id = UUID.randomUUID();
        Sight sight = new Sight();
        when(sightRepository.findById(id)).thenReturn(Optional.of(sight));

        Sight result = sightService.getSightById(id);
        assertEquals(sight, result);
    }

    @Test
    public void testGetSightDTOById() {
        UUID id = UUID.randomUUID();
        Sight sight = new Sight();
        when(sightRepository.findById(id)).thenReturn(Optional.of(sight));

        SightDTO sightDTO = new SightDTO();
        when(sightMapper.mapToSightDTO(sight)).thenReturn(sightDTO);

        SightDTO result = sightService.getSightDTOById(id);
        assertEquals(sightDTO, result);
    }

    @Test
    public void testDeleteSightById() {
        UUID id = UUID.randomUUID();
        sightService.deleteSightById(id);
        Mockito.verify(sightRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void testChangeSightNameById() {
        UUID id = UUID.randomUUID();
        String newName = "New Sight Name";
        Sight sight = new Sight();
        when(sightRepository.findById(id)).thenReturn(Optional.of(sight));

        sightService.changeSightNameById(id, newName);
        assertEquals(newName, sight.getName());
    }

}
