package com.example.demo.domain.repository;

import com.example.demo.domain.entities.CustomerEntity;
import com.example.demo.domain.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>,
        JpaSpecificationExecutor<TaskEntity> {
    List<TaskEntity> findByCustomer(final CustomerEntity customer);
}
