package com.example.demo.domain.mapper;

import com.example.demo.domain.entities.PersonEntity;
import com.example.demo.domain.models.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {
   Person entityToModel(PersonEntity entity);

    PersonEntity modelToEntity(Person model);

   List<Person> entitiesToModelList(List<PersonEntity> list);


}
