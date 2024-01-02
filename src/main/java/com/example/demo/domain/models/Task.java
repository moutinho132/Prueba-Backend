package com.example.demo.domain.models;

import com.example.demo.domain.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.With;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class Task {
    private Integer id;
    @With
    private final String name;
    @With
    private final String description;
    @With
    private final String task;
    @With
    private TaskStatusEnum status;
    @With
    private final Customer customer;
    @With
    private final User creationUser;
    @With
    private final User modificationUser;
    @With
    private final LocalDateTime creationTime;
    @With
    private final LocalDateTime modificationTime;
}
