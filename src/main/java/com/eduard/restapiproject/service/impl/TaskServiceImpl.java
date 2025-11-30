package com.eduard.restapiproject.service.impl;

import com.eduard.restapiproject.domain.task.Task;
import com.eduard.restapiproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Override
    public Task getById(Long id) {
        return null;
    }

    @Override
    public List<Task> getAllByUserId(Long id) {
        return List.of();
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public Task create(Task task, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
