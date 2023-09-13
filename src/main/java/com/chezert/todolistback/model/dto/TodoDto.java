package com.chezert.todolistback.model.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {

    private Long id;

    private String name;

    private Boolean isCompleted;

    private String priority;
}
