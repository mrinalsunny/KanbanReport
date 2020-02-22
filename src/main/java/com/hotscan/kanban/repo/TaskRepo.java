package com.hotscan.kanban.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotscan.kanban.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
