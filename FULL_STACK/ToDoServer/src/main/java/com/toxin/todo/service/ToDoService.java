package com.toxin.todo.service;

import com.toxin.todo.dto.ToDoDtoRequest;
import com.toxin.todo.dto.ToDoDtoResponse;

public interface ToDoService {
    ToDoDtoResponse todo(ToDoDtoRequest request);
}
