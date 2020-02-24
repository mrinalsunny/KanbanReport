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
@Table(name = "Queue")
public class KanbanQueue {

	//------------------------member variables start
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_QUEUE_SEQ")
	@SequenceGenerator(sequenceName = "task_queue_seq", allocationSize = 1, name = "TASK_QUEUE_SEQ")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String details;
	
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;
	//------------------------member variables end
	
	public KanbanQueue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public KanbanQueue(long id, String name, String details, Date modifiedDate) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "TaskQueue [id=" + id + ", name=" + name + ", details=" + details + ", modifiedDate=" + modifiedDate
				+ "]";
	}

}
