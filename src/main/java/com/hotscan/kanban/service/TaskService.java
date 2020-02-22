package com.hotscan.kanban.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotscan.kanban.model.Task;
import com.hotscan.kanban.repo.TaskRepo;


@Service
public class TaskService {
	
	@Autowired
	TaskRepo repo;
	
	public List<Task> getTasks() {
		return repo.findAll();
	}
	
	public Task getTask(long id) {
		try {
			return repo.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addTask(Task task) {
		try {
			if(task.getName() != null && !task.getName().isEmpty()) {
				task.setModifiedDate(new Date());
				repo.save(task);
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean updateTask(long id, Task task) {
		try {
			Task tooUpdate = repo.findById(id).get();
			
			if(task.getName() != null && !task.getName().isEmpty())
				tooUpdate.setName(task.getName());
			
			if(task.getDetails() != null && !task.getDetails().isEmpty())
				tooUpdate.setDetails(task.getDetails());
			
			if(task.getOwner() != null && !task.getOwner().isEmpty())
				tooUpdate.setOwner(task.getOwner());
			
			if(task.getFromQueue() != null && !task.getFromQueue().isEmpty())
				tooUpdate.setFromQueue(task.getFromQueue());
			
			if(task.getToQueue() != null && !task.getToQueue().isEmpty())
				tooUpdate.setToQueue(task.getToQueue());
			
			if(task.getAssigned() != null && !task.getAssigned().isEmpty())
				tooUpdate.setAssigned(task.getAssigned());
			
			if(task.getStatus() != null && !task.getStatus().isEmpty())
				tooUpdate.setStatus(task.getStatus());
			
			tooUpdate.setModifiedDate(new Date());
			
			repo.save(tooUpdate);
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean deleteTask(long id) {
		try {
			repo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
