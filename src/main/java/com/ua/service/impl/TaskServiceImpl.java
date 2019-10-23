package com.ua.service.impl;

import com.ua.dao.TaskDAO;
import com.ua.entity.Task;
import com.ua.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDAO taskDAO;

    @Override
    public void save(Task task) {
        taskDAO.save(task);
    }

    @Override
    public void delete(int id) {
        taskDAO.delete(id);
    }

    @Override
    public Task findOne(int id) {
        return taskDAO.findTasksById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskDAO.findAll();
    }
}
