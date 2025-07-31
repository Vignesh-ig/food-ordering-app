package com.order.controller;

import com.order.Service.CustomerUserDetailsService;
import com.order.config.JwtProvider;
import com.order.enums.USER_ROLE;
import com.order.module.Cart;
import com.order.module.user.entity.User;
import com.order.repository.CartRepository;
import com.order.module.user.repository.UserRepository;
import com.order.request.SignInRequest;
import com.order.request.SignUpRequest;
import com.order.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static com.order.response.AuthResponse.buildAuthResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomerUserDetailsService customerUserDetailsService;
    private final CartRepository cartRepository;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody SignUpRequest request) throws Exception {

        User isEmailExist = userRepository.findByEmail(request.email());

        if (isEmailExist != null)
            throw new Exception("Email is already used with another account");

        User createdUser = User.builder()
                .email(request.email())
                .fullName(request.fullName())
                .password(passwordEncoder.encode(request.password()))
                .role(request.userRole())
                .build();
        User saveUser = userRepository.save(createdUser);

        Cart cart = Cart.builder().customer(saveUser).build();
        cartRepository.save(cart);

        Authentication authentication = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = buildAuthResponse(jwt, "Register success!!!",saveUser.getRole());

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody SignInRequest request) {

        String userName = request.email();
        String password = request.password();

        Authentication authentication = authenticate(userName, password);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String userRole = authorities.isEmpty() ?
                null :
                authorities.iterator().next().getAuthority();

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = buildAuthResponse(jwt, "!!!Login success!!!",USER_ROLE.valueOf(userRole));

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    private Authentication authenticate(String userName, String password) {
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(userName);

        if (userDetails == null)
            throw new BadCredentialsException("Invalid username");

        if (!passwordEncoder.matches(password, userDetails.getPassword()))
            throw new BadCredentialsException("Invalid password");

        return new UsernamePasswordAuthenticationToken(userName, null, userDetails.getAuthorities());
    }

}
