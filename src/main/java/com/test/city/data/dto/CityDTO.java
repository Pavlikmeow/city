package com.test.city.data.dto;

import com.test.city.data.entity.Sight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private String name;
    private String country;
    private int area;
    private int population;
    private List<Sight> sightList;

}
