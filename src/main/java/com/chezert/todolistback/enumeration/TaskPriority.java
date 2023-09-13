package com.chezert.todolistback.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskPriority {

    HIGH("Высокий"),

    NORMAL("Средний"),

    LOW("Низкий");

    private final String nameInRussian;

    public static TaskPriority valueOfName(String nameInRussian) {
        for (TaskPriority taskPriority : values()) {
            if (taskPriority.getNameInRussian().equals(nameInRussian)) {
                return taskPriority;
            }
        }
        return null;
    }
}
