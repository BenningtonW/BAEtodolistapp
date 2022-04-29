package com.qa.baetodolist.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TaskNotFoundExceptionWithID extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1781235689902422072L;

	public TaskNotFoundExceptionWithID(long id) {
		super("User does not exist with ID: " + id);
	}
	
}