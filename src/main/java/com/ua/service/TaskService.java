package com.ua.service;

import com.ua.entity.Task;

import java.util.List;

public interface TaskService {
    void save(Task task);

    void delete(int id);

    Task findOne(int id);

    List<Task> findAll();
}
