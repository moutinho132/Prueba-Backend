package com.example.demo.infrastructure.api.request;

import com.example.demo.domain.models.Customer;
import com.example.demo.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class TaskRequest {
    private Integer id;
    private String description;
    private Customer customer;
    private User creationUser;
    private User modificationUser;
    private LocalDateTime creationTime;
    private LocalDateTime modificationTime;
}
