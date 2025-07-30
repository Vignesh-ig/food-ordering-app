package com.order.Service;

import com.order.module.User;

public interface UserService {

    public User findUserByJwtToken(String jwtToken) throws Exception;

    public User findUserByEmail(String email) throws Exception;

}
