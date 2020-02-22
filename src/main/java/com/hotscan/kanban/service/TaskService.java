package com.hotscan.kanban.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotscan.kanban.model.Task;
import com.hotscan.kanban.repo.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	TaskRepo repo;
	
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
			Task taskToUpdate = repo.findById(id).get();
			System.out.println(taskToUpdate);
			
			if(task.getName().length()>0)
				taskToUpdate.setName(task.getName());
			
			if(task.getDetails().length()>0)
				taskToUpdate.setDetails(task.getDetails());
			
			if(task.getOwner().length()>0)
				taskToUpdate.setOwner(task.getOwner());
			
			if(task.getFromQueue().length()>0)
				taskToUpdate.setFromQueue(task.getFromQueue());
			
			if(task.getToQueue().length()>0)
				taskToUpdate.setToQueue(task.getToQueue());
			
			if(task.getAssigned().length()>0)
				taskToUpdate.setAssigned(task.getAssigned());
			
			if(task.getStatus().length()>0)
				taskToUpdate.setStatus(task.getStatus());
			
			taskToUpdate.setModifiedDate(new Date());
			
			repo.save(taskToUpdate);
			
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