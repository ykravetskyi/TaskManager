package com.ua.dao;

import com.ua.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDAO extends JpaRepository<Task, Integer> {
}
