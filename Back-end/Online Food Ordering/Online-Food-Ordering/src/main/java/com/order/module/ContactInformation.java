package com.order.module;

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
