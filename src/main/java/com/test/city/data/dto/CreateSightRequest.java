package com.test.city.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSightRequest {

    private String name;
    private String type;
    private String address;
    private String architect;
    private UUID cityId;

}
