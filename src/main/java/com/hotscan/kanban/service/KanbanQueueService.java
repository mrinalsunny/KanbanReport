package com.hotscan.kanban.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotscan.kanban.model.KanbanQueue;
import com.hotscan.kanban.repo.KanbanTaskQueueRepo;

@Service
public class KanbanQueueService {

	@Autowired
	KanbanTaskQueueRepo repo;

	public List<KanbanQueue> getQueues() {
		try {
		return repo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public KanbanQueue getQueue(long id) {
		try {
			return repo.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean setQueue(KanbanQueue queue) {
		try {
			queue.setModifiedDate(new Date());
			repo.save(queue);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateQueue(long id, KanbanQueue queue) {
		try {
			KanbanQueue toUpdate = repo.findById(id).get();

			if (queue.getName().length() > 0)
				toUpdate.setName(queue.getName());

			if (queue.getDetails().length() > 0)
				toUpdate.setDetails(queue.getDetails());

			toUpdate.setModifiedDate(new Date());

			repo.save(toUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteQueue(long id) {
		try {
			repo.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
