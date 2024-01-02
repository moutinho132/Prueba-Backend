package com.example.demo.infrastructure.api.controller;

import com.example.demo.application.SecurityManagementService;
import com.example.demo.infrastructure.api.UserApi;
import com.example.demo.infrastructure.api.mapper.UserApiMapper;
import com.example.demo.infrastructure.api.request.UserLoginRequest;
import com.example.demo.infrastructure.api.request.UserRequest;
import com.example.demo.infrastructure.api.response.UserNewResponse;
import com.example.demo.infrastructure.api.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/security")
public class UserController implements UserApi {
    private final SecurityManagementService userManagerService;
    private final UserApiMapper userApiMapper;
    /*@Override
    public String userValidate(@RequestBody UserRequest request) {
        return userManagerService.validateUserLogin(request)?"Benvenido Estimado":"Usuario no autorizado";
    }*/

    @Override
    public UserNewResponse UserLogin(UserLoginRequest request) {
        return userManagerService.validateUserLoginApp(request);
    }

    @Override
    public UserResponse saveUser(@RequestBody UserRequest request) {
        return userApiMapper.modelToResponse(userManagerService.saveUser(userApiMapper.requestToModel(request)));
    }

    @Override
    public List<UserResponse> getAll() {
        return userApiMapper.modelToResponseList(userManagerService.getAll());
    }

    @Override
    public UserResponse findById(Integer id) {
        return userApiMapper.modelToResponse(userManagerService.findById(id));
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userManagerService.delete(id);
    }

    @Override
    public UserResponse findCurrentUser(String token) {
        return  userApiMapper.modelToResponse(userManagerService.findCurrentUser(token));
    }
}
