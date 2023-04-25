package com.test.city.mapper;

import com.test.city.data.dto.NewSight;
import com.test.city.data.dto.SightDTO;
import com.test.city.data.entity.Sight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SightMapper {

    SightDTO mapToSightDTO(Sight sight);

    Sight mapToSight(NewSight newSight);

}
