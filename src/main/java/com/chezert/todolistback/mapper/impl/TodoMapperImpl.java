package com.chezert.todolistback.mapper.impl;

import com.chezert.todolistback.enumeration.TaskPriority;
import com.chezert.todolistback.mapper.TodoMapper;
import com.chezert.todolistback.model.dto.TodoDto;
import com.chezert.todolistback.model.entity.Todo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapperImpl implements TodoMapper {
    @Override
    public TodoDto toDto(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .name(todo.getName())
                .isCompleted(todo.getIsCompleted())
                .priority(todo.getPriority().getNameInRussian())
                .build();
    }

    @Override
    public Todo toEntity(TodoDto todoDto) {
        return Todo.builder()
                .name(todoDto.getName())
                .isCompleted(false)
                .priority(TaskPriority.valueOfName(todoDto.getPriority()))
                .build();
    }

    @Override
    public List<TodoDto> toDtos(List<Todo> todos) {
        return todos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
