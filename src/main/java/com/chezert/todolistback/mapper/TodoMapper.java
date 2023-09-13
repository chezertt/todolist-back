package com.chezert.todolistback.mapper;

import com.chezert.todolistback.model.dto.TodoDto;
import com.chezert.todolistback.model.entity.Todo;

import java.util.List;

public interface TodoMapper {

    TodoDto toDto(Todo todo);

    Todo toEntity(TodoDto todo);

    List<TodoDto> toDtos(List<Todo> todos);
}
