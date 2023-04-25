package com.test.city.controller;

import com.test.city.data.dto.CityDTO;
import com.test.city.data.entity.City;
import com.test.city.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public void createNewCity(@RequestBody City city) {
        cityService.createNewCity(city);
    }

    @GetMapping
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public CityDTO getCityById(@PathVariable UUID id) {
        return cityService.getCityDTOById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable UUID id) {
        cityService.deleteCityById(id);
    }

    @PutMapping("/{id}/{newName}")
    public void changeCityNameById(@PathVariable UUID id, @PathVariable String newName) {
        cityService.changeCityNameById(id, newName);
    }

}
