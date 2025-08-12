package com.order.module.restaurant.service;

import com.order.module.restaurant.dto.RestaurantDTO;
import com.order.module.restaurant.dto.request.SaveUpdateRestaurantRequest;
import com.order.module.restaurant.entity.Restaurant;
import com.order.module.user.entity.User;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(SaveUpdateRestaurantRequest saveRestaurantRequest, User user);

    public Restaurant updateRestaurant(Long restaurantId, SaveUpdateRestaurantRequest updateRestaurantRequest) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant();

    public Restaurant findRestaurantById(Long restaurantId);

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDTO addRemoveToFavorites(Long restaurantId, User userId) throws Exception;

    public Restaurant updateRestaurantStatus(Long restaurantId) throws Exception;

}
