package com.test.city.controller;

import com.test.city.data.dto.NewSight;
import com.test.city.data.dto.SightDTO;
import com.test.city.data.entity.City;
import com.test.city.data.entity.Sight;
import com.test.city.service.SightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sight")
@RequiredArgsConstructor
public class SightController {

    private final SightService sightService;

    @PostMapping
    public void createNewSight(@RequestBody NewSight newSight) {
        sightService.createNewSight(newSight);
    }

    @GetMapping
    public List<SightDTO> getAllSights() {
        return sightService.getAllSights();
    }

    @GetMapping("/{id}")
    public SightDTO getSightById(@PathVariable UUID id) {
        return sightService.getSightDTOById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSightById(@PathVariable UUID id) {
        sightService.deleteSightById(id);
    }

    @PutMapping("/{id}/{newName}")
    public void changeSightNameById(@PathVariable UUID id, @PathVariable String newName) {
        sightService.changeSightNameById(id, newName);
    }

}
