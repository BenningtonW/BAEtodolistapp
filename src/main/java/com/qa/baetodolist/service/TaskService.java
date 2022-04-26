package com.qa.baetodolist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.qa.baetodolist.domain.Task;
import com.qa.baetodolist.repo.TaskRepo;


@Service
public class TaskService {

	private TaskRepo repo;

	public TaskService(TaskRepo repo) {
		this.repo = repo;
	}
	
	// Get By ID (get one Task)
	public Task getById(long id) {
		return repo.findById(id).get(); //.get() will either get the Task (if exists) OR throw NoSuchElementException
	}
	
	// Get ALL tasks
	public List<Task> getAll() {
		return repo.findAll();
	}
	
	// Get By Task (get one Task)
		public Task getByTask(String task) {
			return repo.findByTask(task).get();
	}
	
	// Create a new task
	public Task create(Task task) {
		return repo.saveAndFlush(task);
	}
	
	// Update a task
		public Task update(long id, Task task) {
			Task existing = repo.findById(id).get(); // Get the EXISTING task
			existing.setTaskToDo(task.getTaskToDo()); // Change EXISTING task.
			return repo.saveAndFlush(existing);
		}
		
		// Delete a user
			public boolean delete(long id) {
				repo.deleteById(id);
				return !repo.existsById(id);
				
			}
	}
	