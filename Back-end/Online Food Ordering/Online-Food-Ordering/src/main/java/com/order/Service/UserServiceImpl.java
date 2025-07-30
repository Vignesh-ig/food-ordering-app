package com.order.Service;

import com.order.config.JwtProvider;
import com.order.module.User;
import com.order.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwtToken) throws Exception {
        log.info("Find the user with Jwt Token");

        String email = jwtProvider.getEmailFromJwtToken(jwtToken);
        return findUserByEmail(email);
    }

    public User findUserByEmail(String email) throws Exception {
        log.info("Find the user with email");

        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new Exception("User not found for the email: " + email);

        return user;
    }
}
