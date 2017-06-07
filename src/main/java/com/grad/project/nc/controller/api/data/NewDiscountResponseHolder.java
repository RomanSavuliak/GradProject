package com.grad.project.nc.controller.api.data;

import lombok.Data;


@Data
public class NewDiscountResponseHolder {
    private String status;
    private String message;
    private Long discountID;

}
