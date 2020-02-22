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
		return repo.findById(id).get();
	}

	public boolean setTask(Task task) {
		try {
			repo.save(task);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean updateTask(long id, Task task) {
		try {
			Task tooUpdate = repo.findById(id).get();
			
			if(task.getName().length()>0)
				tooUpdate.setName(task.getName());
			
			if(task.getDetails().length()>0)
				tooUpdate.setDetails(task.getDetails());
			
			if(task.getOwner().length()>0)
				tooUpdate.setOwner(task.getOwner());
			
			if(task.getFromQueue().length()>0)
				tooUpdate.setFromQueue(task.getFromQueue());
			
			if(task.getToQueue().length()>0)
				tooUpdate.setToQueue(task.getToQueue());
			
			if(task.getAssigned().length()>0)
				tooUpdate.setAssigned(task.getAssigned());
			
			if(task.getStatus().length()>0)
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
