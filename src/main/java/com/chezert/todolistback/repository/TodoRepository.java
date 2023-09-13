package com.chezert.todolistback.repository;

import com.chezert.todolistback.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByIdDesc();
}
