package com.chezert.todolistback.service;

import com.chezert.todolistback.model.dto.TodoDto;

import java.util.List;

public interface TodoService {

    List<TodoDto> getAll();

    TodoDto getById(Long id);

    void save(TodoDto todoDto);

    void deleteById(Long id);
}
