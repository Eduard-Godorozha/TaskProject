package com.eduard.restapiproject.web.controller;

import com.eduard.restapiproject.domain.task.Task;
import com.eduard.restapiproject.service.TaskService;
import com.eduard.restapiproject.web.dto.task.TaskDto;
import com.eduard.restapiproject.web.dto.validation.OnUpdate;
import com.eduard.restapiproject.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @PutMapping
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updateedTask = taskService.update(task);
        return taskMapper.toDto(updateedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.delete(id);
    }

}
