package org.architecture.todo_test.service.Impl;

import org.architecture.todo_test.mapper.TaskMapper;
import org.architecture.todo_test.persistance.entities.Task;
import org.architecture.todo_test.persistance.repository.ITaskRepository;
import org.architecture.todo_test.service.ITaskService;
import org.architecture.todo_test.web.dtos.request.TaskRequest;
import org.architecture.todo_test.web.dtos.response.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ITaskRepository repository;

    @Override
    @Transactional
    public int create(TaskRequest taskRequest) {
        return repository.save(taskMapper.toEntity(taskRequest));
    }

    @Override
    @Transactional
    public int update(Long id, TaskRequest taskRequest) {
        Task task = taskMapper.toEntity(taskRequest);
        task.setId(id);
        return repository.update(task);
    }

    @Override
    public List<TaskResponse> findAll() {
        List<Task> tasks = repository.findAll();
        return tasks.stream().map(x -> taskMapper.toResponse(x)).collect(Collectors.toList());
    }

    @Override
    public TaskResponse findById(Long id) {
        Task task = repository.findById(id);
        return taskMapper.toResponse(task);
    }

    @Override
    @Transactional
    public int delete(Long id) {
        return repository.delete(id);
    }
}
