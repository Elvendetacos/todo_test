package org.architecture.todo_test.persistance.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter @Setter
public class Task {
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;
}
