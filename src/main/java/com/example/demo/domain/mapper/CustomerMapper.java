package com.example.demo.domain.mapper;

import com.example.demo.domain.entities.CustomerEntity;
import com.example.demo.domain.entities.UserEntity;
import com.example.demo.domain.models.Customer;
import com.example.demo.domain.models.User;
import io.micrometer.common.util.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        uses = {
                PersonMapper.class,
        }
)
public interface CustomerMapper {

    Customer entityToModel(CustomerEntity entity);

    List<Customer> entitiesToModelList(List<CustomerEntity> list);

    CustomerEntity modelToEntity(Customer model);

    List<CustomerEntity> modelsToEntityList(List<Customer> list);


}
