package com.ua.service;

import com.ua.entity.Task;

import java.util.List;

public interface TaskService {
    void save(Task task);

    void delete(int id);

    List<Task> findAll();
}
