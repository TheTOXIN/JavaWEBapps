package com.toxin.todo.service;

import com.toxin.todo.dto.ToDoDtoRequest;
import com.toxin.todo.dto.ToDoDtoResponse;
import com.toxin.todo.entity.Task;
import com.toxin.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final TaskRepository taskRepository;

    @Autowired
    public ToDoServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public ToDoDtoResponse todo(ToDoDtoRequest request) {
        return new ToDoDtoResponse(
             taskRepository.findByUser_Id(request.getUserId())
                .stream()
                .map(Task::getId)
                .collect(Collectors.toList())
        );
    }

}
