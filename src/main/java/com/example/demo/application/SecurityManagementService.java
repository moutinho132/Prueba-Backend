package com.example.demo.application;

import com.example.demo.domain.models.User;
import com.example.demo.domain.service.UserService;
import com.example.demo.infrastructure.api.config.Jwt;
import com.example.demo.infrastructure.api.request.UserLoginRequest;
import com.example.demo.infrastructure.api.response.UserNewResponse;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class SecurityManagementService {
    private final UserService service;
    private Jwt jwt;

    public User saveUser(final User user) {
        return service.saveUser(user);
    }

    public List<User> getAll() {
        return service.getAll();
    }

    public User findById(final Integer id) {
        //logica nose algo mas
        return service.findById(id);
    }

    public boolean delete(final Integer id) {
        return service.deleteUser(id);
    }

    public UserNewResponse validateUserLoginApp(UserLoginRequest request) {
        UserNewResponse newResponse = null;
        User user = service.findByEmailAndPassword(request);
        if (Objects.nonNull(user)) {
            newResponse = UserNewResponse.builder().id(user.getId())
                    .token(jwt.create(String.valueOf(user.getId()), user.getName(), user.getEmail())).
                    email(user.getEmail())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .build();
        }else{
            throw new UnauthorizedException("User not valid");
        }
        return newResponse;
    }

    public User findCurrentUser(String token) {
        try {
            log.info("Inf Curren User ");
            return jwt.findCurrentUser(token);
        }catch (ExpiredJwtException e){
            throw new ExpiredJwtException(null, null, "Token expirado");
        }
    }
}
