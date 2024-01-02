package com.example.demo.infrastructure.api.controller;

import com.example.demo.application.TaskManagementService;
import com.example.demo.domain.models.Customer;
import com.example.demo.domain.models.Task;
import com.example.demo.domain.service.TaskService;
import com.example.demo.infrastructure.api.TaskApi;
import com.example.demo.infrastructure.api.mapper.TaskApiMapper;
import com.example.demo.infrastructure.api.request.TaskRequest;
import com.example.demo.infrastructure.api.response.CustomerResponse;
import com.example.demo.infrastructure.api.response.PaginatedResponse;
import com.example.demo.infrastructure.api.response.TaskReponse;
import com.example.demo.infrastructure.api.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskController implements TaskApi {
    private TaskApiMapper mapper;
    private TaskService service;
    private TaskManagementService managementService;
    @Override
    public TaskReponse save(TaskRequest request, String token) {
        return mapper.modelToResponse(managementService.saveTask(mapper.requestToModel(request),token));
    }

    @Override
    public PaginatedResponse<TaskReponse> findAll(Integer page,
                                                  Integer size, String direction, String attribute,String token) {
        final List<Task> response = managementService.findAll(page, size, direction, attribute);
        return PaginatedResponse.<TaskReponse>builder()
                .total(response.size())
                .page(page)
                .size(response.size())
                .items(mapper.modelToResponseList(response))
                .build();
    }

    @Override
    public TaskReponse findById(Integer id,String token) {
        return mapper.modelToResponse(managementService.findById(id,token));
    }

    @Override
    public TaskReponse findByCustomer(Integer id, String token) {
        return mapper.modelToResponse(managementService.findByCustomer(id,token));
    }
}
