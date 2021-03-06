package com.grad.project.nc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long addressId;
    private String apartmentNumber;
    private Location location;
}