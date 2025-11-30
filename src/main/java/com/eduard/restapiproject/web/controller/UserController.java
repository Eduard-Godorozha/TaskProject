package com.eduard.restapiproject.web.controller;

import com.eduard.restapiproject.domain.task.Task;
import com.eduard.restapiproject.domain.user.User;
import com.eduard.restapiproject.service.TaskService;
import com.eduard.restapiproject.service.UserService;
import com.eduard.restapiproject.web.dto.task.TaskDto;
import com.eduard.restapiproject.web.dto.user.UserDto;
import com.eduard.restapiproject.web.dto.validation.OnCreate;
import com.eduard.restapiproject.web.dto.validation.OnUpdate;
import com.eduard.restapiproject.web.mappers.TaskMapper;
import com.eduard.restapiproject.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    private final TaskService taskService;

    private final UserMapper userMapper;

    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto taskDto){
        Task task = taskMapper.toEntity(taskDto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }

}
