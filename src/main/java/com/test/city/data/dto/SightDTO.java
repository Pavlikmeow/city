package com.test.city.data.dto;

import com.test.city.data.entity.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SightDTO {
    private String name;
    private String type;
    private String address;
    private String architect;
    private City city;
}
