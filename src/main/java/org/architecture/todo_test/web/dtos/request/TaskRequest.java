package org.architecture.todo_test.web.dtos.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

@Builder
@Getter @Setter
public class TaskRequest {
    private String name;

    private String description;

    @FutureOrPresent
    private LocalDate startDate;
}
