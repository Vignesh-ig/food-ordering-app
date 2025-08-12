package com.order.module.restaurant.service.impl;

import com.order.module.restaurant.dto.RestaurantDTO;
import com.order.module.restaurant.dto.request.SaveUpdateRestaurantRequest;
import com.order.module.restaurant.entity.Restaurant;
import com.order.module.restaurant.service.RestaurantService;
import com.order.module.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.spi.RegisterableService;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    @Override
    public Restaurant createRestaurant(SaveUpdateRestaurantRequest saveRestaurantRequest, User user) {
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, SaveUpdateRestaurantRequest updateRestaurantRequest) throws Exception {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return List.of();
    }

    @Override
    public List<Restaurant> searchRestaurant() {
        return List.of();
    }

    @Override
    public Restaurant findRestaurantById(Long restaurantId) {
        return null;
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public RestaurantDTO addRemoveToFavorites(Long restaurantId, User userId) throws Exception {
        return null;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long restaurantId) throws Exception {
        return null;
    }
}
