package com.hotscan.kanban.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotscan.kanban.model.KanbanQueue;

public interface KanbanTaskQueueRepo extends JpaRepository<KanbanQueue, Long> {

}
