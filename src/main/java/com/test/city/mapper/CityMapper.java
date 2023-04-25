package com.test.city.mapper;

import com.test.city.data.dto.CityDTO;
import com.test.city.data.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDTO mapToCityDTO(City city);

}
