package com.example.demo.domain.repository;

import com.example.demo.domain.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>,
        JpaSpecificationExecutor<CustomerEntity> {
}
