package com.example.demo.domain.repository;

import com.example.demo.domain.entities.CustomerEntity;
import com.example.demo.domain.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>,
        JpaSpecificationExecutor<TaskEntity> {
    Optional<TaskEntity> findByCustomer(final CustomerEntity customer);
}
