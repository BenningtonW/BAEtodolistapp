package com.qa.baetodolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.baetodolist.domain.Task;
import com.qa.baetodolist.service.TaskService;

@RestController
@CrossOrigin

public class TaskController {

	private TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	// Get by ID (get one Task)
	@GetMapping("/getById/{id}") // localhost:8080/getById/id
	public ResponseEntity<Task> getById(@PathVariable long id) {
		return new ResponseEntity<> (service.getById(id), HttpStatus.OK);
	}

	// Get All	
	@GetMapping("/getAll") // localhost:8080/getAll
	public ResponseEntity <List<Task>> getAll() {
		return new ResponseEntity<> (service.getAll(), HttpStatus.OK);
	}

	// Post
	@PostMapping("/create") // localhost:8080/create
	public ResponseEntity<Task> create(@RequestBody Task task) {
		return new ResponseEntity<>(service.create(task), HttpStatus.CREATED);
	}

	// Put/Patch
	@PutMapping("/update/{id}") // localhost:8080/update/id
	public ResponseEntity<Task> update(@PathVariable long id, @RequestBody Task task) {
		return new ResponseEntity<>(service.update(id, task), HttpStatus.ACCEPTED);
	}	
		// Delete
	@DeleteMapping("/delete/{id}") //localhost:8080/delete/idesponseEntity<Boolean>
	public ResponseEntity<?> delete(@PathVariable long id) {
		return (service.delete(id))? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
