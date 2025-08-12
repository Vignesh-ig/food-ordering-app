package com.order.module.restaurant.dto.request;

import com.order.module.restaurant.entity.Address;
import com.order.module.restaurant.entity.ContactInformation;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record SaveUpdateRestaurantRequest(

        @NotBlank(message = "Id must not be null")
        Long id,
        @NotBlank(message = "Name must not be null")
        String name,
        String description,
        String cuisineType,
        Address address,
        ContactInformation contactInformation,
        String openingHours,
        List<String> images
) {
}
