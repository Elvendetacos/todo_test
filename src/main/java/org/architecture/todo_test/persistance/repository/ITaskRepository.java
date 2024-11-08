package org.architecture.todo_test.persistance.repository;

import org.apache.ibatis.annotations.Mapper;
import org.architecture.todo_test.persistance.entities.Task;

import java.util.List;

@Mapper
public interface ITaskRepository {
    List<Task> findAll();

    Task findById(Long id);

    int save(Task task);

    int update(Task task);

    int delete(Long id);
}
