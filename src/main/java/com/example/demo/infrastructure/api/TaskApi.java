package com.example.demo.infrastructure.api;

import com.example.demo.infrastructure.api.request.TaskRequest;
import com.example.demo.infrastructure.api.response.PaginatedResponse;
import com.example.demo.infrastructure.api.response.TaskReponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskApi {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    TaskReponse save(@RequestBody @Valid TaskRequest request, @RequestHeader(value = "Authorization") String token);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    PaginatedResponse<TaskReponse> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", defaultValue = "10") Integer size,
                                           @RequestParam(name = "sort-direction", defaultValue = "DESC") String direction,
                                           @RequestParam(name = "sort-attribute", defaultValue = "id") String attribute,
                                           @RequestHeader(value = "Authorization") String token
    );

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    TaskReponse findById(@PathVariable("id") Integer id,@RequestHeader(value="Authorization") String token);

    @GetMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    List<TaskReponse> findByCustomer(@PathVariable("id") Integer id, @RequestHeader(value="Authorization") String token);
}
