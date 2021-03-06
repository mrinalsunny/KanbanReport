package com.hotscan.kanban.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Task {

	//------------------------member variables start
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_SEQ")
	@SequenceGenerator(sequenceName = "task_seq", allocationSize = 1, name = "TASK_SEQ")
	private Long id;
	
	@Column(name = "QUEUE_ID", nullable = false)
	private Long queueId;
	
	@Column(nullable = false)
	private String name;
	
	private String details;
	
	private String owner;
	
	@Column(name = "FROM_QUEUE")
	private String fromQueue;
	
	@Column(name = "TO_QUEUE")
	private String toQueue;
	
	private String assigned;
	
	private String status;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	//------------------------member variables end
	
	
	public Task() {
	}

	public Task(long id, long queueId, String name, String details, String owner, String fromQueue, String toQueue,
			String assigned, String status, Date modifiedDate) {
		super();
		this.id = id;
		this.queueId = queueId;
		this.name = name;
		this.details = details;
		this.owner = owner;
		this.fromQueue = fromQueue;
		this.toQueue = toQueue;
		this.assigned = assigned;
		this.status = status;
		this.modifiedDate = modifiedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getQueueId() {
		return queueId;
	}

	public void setQueueId(long queueId) {
		this.queueId = queueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFromQueue() {
		return fromQueue;
	}

	public void setFromQueue(String fromQueue) {
		this.fromQueue = fromQueue;
	}

	public String getToQueue() {
		return toQueue;
	}

	public void setToQueue(String toQueue) {
		this.toQueue = toQueue;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", queueId=" + queueId + ", name=" + name + ", details=" + details + ", owner="
				+ owner + ", fromQueue=" + fromQueue + ", toQueue=" + toQueue + ", assigned=" + assigned + ", status="
				+ status + ", modifiedDate=" + modifiedDate + "]";
	}

}