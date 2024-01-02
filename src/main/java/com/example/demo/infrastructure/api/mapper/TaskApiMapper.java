package com.example.demo.infrastructure.api.mapper;

import com.example.demo.domain.models.Task;
import com.example.demo.infrastructure.api.request.TaskRequest;
import com.example.demo.infrastructure.api.response.TaskReponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                PersonApiMapper.class,
                UserApiMapper.class,
        }

)
public interface TaskApiMapper {
        TaskReponse modelToResponse(final Task model);

        Task requestToModel(final TaskRequest request);

        List<TaskReponse> modelToResponseList(final List<Task> tasks);
}
