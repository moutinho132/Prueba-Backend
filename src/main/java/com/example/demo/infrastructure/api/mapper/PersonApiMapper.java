package com.example.demo.infrastructure.api.mapper;

import com.example.demo.domain.models.Person;
import com.example.demo.infrastructure.api.request.PersonRequest;
import com.example.demo.infrastructure.api.response.PersonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface PersonApiMapper {
    Person requestToModel(PersonRequest request);

    List<Person> requestToModelList(List<PersonRequest> list);

    PersonResponse modelToResponse(Person model);

    List<PersonResponse> modelsToResponseList(List<Person> list);
}
