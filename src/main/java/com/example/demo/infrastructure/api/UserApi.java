package com.example.demo.infrastructure.api;

import com.example.demo.infrastructure.api.request.UserLoginRequest;
import com.example.demo.infrastructure.api.request.UserRequest;
import com.example.demo.infrastructure.api.response.UserNewResponse;
import com.example.demo.infrastructure.api.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//creación de apis para mi controlador
public interface UserApi {
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    UserNewResponse UserLogin(@RequestBody UserLoginRequest request);


    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    UserResponse saveUser(@RequestBody UserRequest request);


    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    List<UserResponse> getAll();


    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    UserResponse findById(@PathVariable("id") Integer id);

    @DeleteMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    boolean deleteUser(@PathVariable("id") Integer id);

    @GetMapping(value = "/users/current", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    UserResponse findCurrentUser(@RequestHeader(value = "Authorization") String token);
}
