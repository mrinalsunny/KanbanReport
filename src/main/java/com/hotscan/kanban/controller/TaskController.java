package com.hotscan.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotscan.kanban.model.Task;
import com.hotscan.kanban.service.TaskService;

@RestController
@RequestMapping("/kanban/task")
public class TaskController {

	@Autowired
	TaskService service;

	@GetMapping("/get/all")
	public List<Task> getTask() {
		return service.getTasks();
	}
	
	@GetMapping("/get/{id}")
	public Task getTask(@PathVariable long id) {
		return service.getTask(id);
	}

	@PostMapping("/add")
	public boolean addTask(@RequestBody Task task) {
		return service.addTask(task);
	}
	
	@PutMapping("/update/{id}")
	public boolean updateTask(@PathVariable("id") long id, @RequestBody Task task) {
		return service.updateTask(id, task);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteTask(@PathVariable("id") long id) {
		return service.deleteTask(id);
	}
}
