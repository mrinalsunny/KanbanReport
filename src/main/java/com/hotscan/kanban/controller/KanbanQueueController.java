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

import com.hotscan.kanban.model.KanbanQueue;
import com.hotscan.kanban.service.KanbanQueueService;

@RestController
@RequestMapping("/queue")
public class KanbanQueueController {

	@Autowired
	KanbanQueueService service;

	@GetMapping("/get/all")
	public List<KanbanQueue> getQueues() {
		return service.getQueues();
	}
	
	@GetMapping("/get/{id}")
	public KanbanQueue getQueue(@PathVariable long id) {
		return service.getQueue(id);
	}

	@PostMapping("/set")
	public boolean setQueue(@RequestBody KanbanQueue queue) {
		return service.setQueue(queue);
	}
	
	@PutMapping("/update/{id}")
	public boolean updateQueue(@PathVariable("id") long id, @RequestBody KanbanQueue queue) {
		return service.updateQueue(id, queue);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteQueue(@PathVariable("id") long id) {
		return service.deleteQueue(id);
	}
}
