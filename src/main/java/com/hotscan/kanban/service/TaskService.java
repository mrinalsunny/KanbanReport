package com.hotscan.kanban.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotscan.kanban.exceptions.ResourceExceptions;
import com.hotscan.kanban.model.KanbanQueue;
import com.hotscan.kanban.model.Task;
import com.hotscan.kanban.repo.KanbanTaskQueueRepo;
import com.hotscan.kanban.repo.TaskRepo;

@Service
public class TaskService {

	@Autowired
	TaskRepo repo;
	@Autowired
	KanbanTaskQueueRepo queueRepo;
	@Autowired
	ResourceExceptions exceptions;
	
	public List<Task> getTasks() {
		return repo.findAll();
	}

	public Task getTask(long id) {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addTask(Task task) {
		try {
			if (task.getName() != null && !task.getName().isEmpty() && task.getQueueId() != null
					&& !task.getQueueId().toString().isEmpty()) {
				if (isQueuePresent(task.getQueueId())) {
					task.setModifiedDate(new Date());
					repo.save(task);
					return true;
				} else
					return false;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateTask(Long id, Task task) {
		try {
			Task toUpdate = repo.findById(id).get();

			if (task.getQueueId() != null && !task.getQueueId().toString().isEmpty())
				toUpdate.setQueueId(task.getQueueId());

			if (task.getName() != null && !task.getName().isEmpty())
				toUpdate.setName(task.getName());

			if (task.getDetails() != null && !task.getDetails().isEmpty())
				toUpdate.setDetails(task.getDetails());

			if (task.getOwner() != null && !task.getOwner().isEmpty())
				toUpdate.setOwner(task.getOwner());

			if (task.getFromQueue() != null && !task.getFromQueue().isEmpty())
				toUpdate.setFromQueue(task.getFromQueue());

			if (task.getToQueue() != null && !task.getToQueue().isEmpty())
				toUpdate.setToQueue(task.getToQueue());

			if (task.getAssigned() != null && !task.getAssigned().isEmpty())
				toUpdate.setAssigned(task.getAssigned());

			if (task.getStatus() != null && !task.getStatus().isEmpty())
				toUpdate.setStatus(task.getStatus());

			toUpdate.setModifiedDate(new Date());

			repo.save(toUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteTask(long id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isQueuePresent(Long queueId) {
		try {
			KanbanQueue queue = queueRepo.findById(queueId).get();
			if (queue.getId() != null) {
				System.out.println("From TaskService.isQueuePresent : " + queue.getId());
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			exceptions.serviceException(e);
			return false;
		}
	}

}
