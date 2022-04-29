package com.qa.baetodolist.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	Create a column called "task_to_do"
	@Column(name = "tasktodo", nullable = false)
//	Create column which cant be empty
	private String taskToDo;
	
//	Default constructor (doesnt have any arguments)
	public Task() {}

	
public Task(String taskToDo) {
		super();
		this.taskToDo = taskToDo;
	}


	//  used for creating and inserting
	public String getTaskToDo() {
		return taskToDo;
	}

//	Used for reading/selecting and testing
	public Task(long id, String taskToDo) {
		super();
		this.id = id;
		this.taskToDo = taskToDo;
	}

	public void setTaskToDo(String taskToDo) {
		this.taskToDo = taskToDo;
	}

//	Used for reading
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", taskToDo=" + taskToDo + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, taskToDo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return id == other.id && Objects.equals(taskToDo, other.taskToDo);
	}
	
	
}
