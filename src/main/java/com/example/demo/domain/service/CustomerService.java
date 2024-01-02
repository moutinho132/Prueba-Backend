package com.example.demo.domain.service;

import com.example.demo.application.CustomerNotFoundException;
import com.example.demo.application.PersonFieldsBlockerService;
import com.example.demo.domain.CustomerSpecification;
import com.example.demo.domain.mapper.CustomerMapper;
import com.example.demo.domain.models.Customer;
import com.example.demo.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class CustomerService {
    private CustomerMapper mapper;
    private CustomerRepository repository;
    private PersonFieldsBlockerService personFieldsBlockerService;

    public Customer save(final Customer model) {
        if (Objects.requireNonNullElse(model.getId(), 0) != 0) {
            existsById(model.getId());
        }

        return mapper.entityToModel(repository.save(mapper.modelToEntity(model)));
    }

    public Long count(final CustomerSpecification specification) {
        return repository.count(specification);
    }

    public List<Customer> findAll(final Pageable pageable) {
        return mapper.entitiesToModelList(repository
                        .findAll( pageable)
                        .toList());
    }

    public void existsById(final Integer id) {
        if (!repository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
    }

    public Customer findById(final Integer id, final String token) {
        return (Customer) personFieldsBlockerService.block(
                mapper.entityToModel(repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id)))
        ,token);
    }
}
