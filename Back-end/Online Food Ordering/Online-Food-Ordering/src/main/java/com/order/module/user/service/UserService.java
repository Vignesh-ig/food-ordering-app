package com.order.module.user.service;

import com.order.module.user.entity.User;

public interface UserService {

    public User findUserByJwtToken(String jwtToken) throws Exception;

    public User findUserByEmail(String email) throws Exception;

}
