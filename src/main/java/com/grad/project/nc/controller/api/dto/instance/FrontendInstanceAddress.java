package com.grad.project.nc.controller.api.dto.instance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FrontendInstanceAddress {

    private String apartment;
    private String city;
    private String street;
    private String building;



}
