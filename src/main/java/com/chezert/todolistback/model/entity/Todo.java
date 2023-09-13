package com.chezert.todolistback.model.entity;

import com.chezert.todolistback.enumeration.TaskPriority;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isCompleted;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
}
