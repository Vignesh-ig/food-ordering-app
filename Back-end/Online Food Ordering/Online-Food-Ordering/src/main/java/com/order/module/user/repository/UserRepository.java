package com.order.module.user.repository;

import com.order.module.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public  User findByEmail(String username);
}
