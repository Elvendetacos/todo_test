package org.architecture.todo_test.service;

import org.architecture.todo_test.persistance.entities.Task;
import org.architecture.todo_test.web.dtos.request.TaskRequest;
import org.architecture.todo_test.web.dtos.response.TaskResponse;

import java.util.List;

public interface ITaskService {
    int create(TaskRequest taskRequest);

    int update(Long id, TaskRequest taskRequest);

    List<TaskResponse> findAll();

    TaskResponse findById(Long id);

    int delete(Long id);
}
