package com.eduard.restapiproject.web.mappers;

import com.eduard.restapiproject.domain.task.Task;
import com.eduard.restapiproject.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task toEntity(TaskDto dto);

}
