package com.chezert.todolistback.service.impl;

import com.chezert.todolistback.mapper.TodoMapper;
import com.chezert.todolistback.model.dto.TodoDto;
import com.chezert.todolistback.model.entity.Todo;
import com.chezert.todolistback.repository.TodoRepository;
import com.chezert.todolistback.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    private final TodoMapper todoMapper;

    @Override
    public List<TodoDto> getAll() {
        return todoMapper.toDtos(todoRepository.findAllByOrderByIdDesc());
    }

    @Override
    public TodoDto getById(Long id) {
        return todoMapper.toDto(todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No task with id=" + id)));
    }

    @Override
    public void save(TodoDto todoDto) {
        todoRepository.save(todoMapper.toEntity(todoDto));
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void completeById(Long id) {
        Todo todoToComplete = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No todo with id = " + id));
        todoToComplete.setIsCompleted(!todoToComplete.getIsCompleted());
        todoRepository.save(todoToComplete);
    }
}
