package com.order.module.restaurant.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactInformation {

    private String email;
    private String mobile;
    private String instagram;
    private String twitter;
}
