package com.toxin.todo.controller;

import com.toxin.todo.dto.ToDoDtoRequest;
import com.toxin.todo.dto.ToDoDtoResponse;
import com.toxin.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/todo")
    public ToDoDtoResponse todo(@RequestBody ToDoDtoRequest request) {
        return toDoService.todo(request);
    }

}
