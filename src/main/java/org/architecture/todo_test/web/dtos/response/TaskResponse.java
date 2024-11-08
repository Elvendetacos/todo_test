package org.architecture.todo_test.web.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter @Setter
public class TaskResponse {
    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;
}
