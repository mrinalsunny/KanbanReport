package com.hotscan.kanban;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hotscan.kanban.repo.TaskRepo;

@SpringBootApplication
public class KanbanReportApplication implements ApplicationRunner {

	@Autowired
	TaskRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(KanbanReportApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		Task task = new Task();
//		task.setDetails("Task1");
//		task.setModifiedDate(new Date());
//		repo.save(task);
//		System.out.println("Stub data pushed to DB");
	}
}
