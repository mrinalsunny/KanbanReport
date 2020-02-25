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
	
	@Autowired
	ResourceExceptions exceptions;

	public List<KanbanQueue> getQueues() {
		try {
		return repo.findAll();
		}catch(Exception e) {
			exceptions.serviceException(e);
			return null;
		}
	}

	public KanbanQueue getQueue(long id) {
		try {
			return repo.findById(id).get();
		}catch(Exception e) {
			exceptions.serviceException(e);
			return null;
		}
	}
	
	public boolean addQueue(KanbanQueue queue) {
		try {
			if(queue.getName()!= null && !queue.getName().isEmpty()) {
				queue.setModifiedDate(new Date());
				repo.save(queue);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			exceptions.serviceException(e);
			return false;
		}
	}

	public boolean updateQueue(long id, KanbanQueue queue) {
		try {
			KanbanQueue toUpdate = repo.findById(id).get();
			System.out.println(toUpdate);

			if (queue.getName()!= null && !queue.getName().isEmpty())
				toUpdate.setName(queue.getName());

			if (queue.getDetails() != null && !queue.getDetails().isEmpty())
				toUpdate.setDetails(queue.getDetails());

			toUpdate.setModifiedDate(new Date());

			repo.save(toUpdate);

		} catch (Exception e) {
			exceptions.serviceException(e);
			return false;
		}
		return true;	
	}

	public boolean deleteQueue(long id) {
		try {
			repo.deleteById(id);
		}catch(Exception e) {
			exceptions.serviceException(e);
			return false;
		}
		return true;
	}

}
