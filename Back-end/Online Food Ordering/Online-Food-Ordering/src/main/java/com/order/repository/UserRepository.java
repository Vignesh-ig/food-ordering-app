package com.order.repository;

import com.order.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public  User findByEmail(String username);
}
