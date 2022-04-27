package com.qa.baetodolist.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.baetodolist.domain.Task;

@Repository
public interface TaskRepo extends JpaRepository <Task, Long> {
	
Optional<Task> findByTaskToDo(String task);
	

	
}