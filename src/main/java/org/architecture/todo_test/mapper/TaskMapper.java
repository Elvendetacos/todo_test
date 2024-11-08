package org.architecture.todo_test.mapper;

import org.architecture.todo_test.persistance.entities.Task;
import org.architecture.todo_test.web.dtos.request.TaskRequest;
import org.architecture.todo_test.web.dtos.response.TaskResponse;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskRequest request){
        Task task = new Task();
        task.setDescription(request.getDescription());
        task.setName(request.getName());
        task.setStartDate(request.getStartDate());
        return task;
    }

    public TaskResponse toResponse(Task task){
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .startDate(task.getStartDate())
                .build();
    }
}
