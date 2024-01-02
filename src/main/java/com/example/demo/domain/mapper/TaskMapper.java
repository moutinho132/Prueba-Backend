package com.example.demo.domain.mapper;

import com.example.demo.domain.entities.TaskEntity;
import com.example.demo.domain.models.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                CustomerMapper.class,
        }
)
public interface TaskMapper {
    Task entityToModel(TaskEntity entity);

    List<Task> entitiesToModelList(List<TaskEntity> list);

    TaskEntity modelToEntity(Task model);

    List<TaskEntity> modelsToEntityList(List<Task> list);


}
