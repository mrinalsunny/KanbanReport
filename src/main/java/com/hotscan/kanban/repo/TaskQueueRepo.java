package com.hotscan.kanban.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotscan.kanban.model.TaskQueue;

public interface TaskQueueRepo extends JpaRepository<TaskQueue, Long> {

}
