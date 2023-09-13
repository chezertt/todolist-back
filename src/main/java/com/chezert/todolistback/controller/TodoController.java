package com.chezert.todolistback.controller;

import com.chezert.todolistback.model.dto.TodoDto;
import com.chezert.todolistback.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoDto> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public TodoDto getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @PatchMapping("/{id}/complete")
    public void completeById(@PathVariable Long id) {
        todoService.completeById(id);
    }

    @PostMapping
    public void saveNewTodo(@RequestBody TodoDto todoDto) {
        log.info("Trying to save new todo:\n{}", todoDto);
        todoService.save(todoDto);
        log.info("Saved todo with name = {}", todoDto.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        log.info("Trying to delete todo with ID = {}", id);
        todoService.deleteById(id);
        log.info("Deleted todo with ID = {}", id);
    }
}
