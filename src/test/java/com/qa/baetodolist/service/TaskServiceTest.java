package com.qa.baetodolist.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.baetodolist.domain.Task;
import com.qa.baetodolist.repo.TaskRepo;


@SpringBootTest
public class TaskServiceTest {

	@Autowired
	private TaskService service;
	
	@MockBean
	private TaskRepo repo;
	
	@Test
	public void getAllTest() {
		List<Task> output = new ArrayList<>();
		output.add(new Task("go shopping"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		Optional<Task> OptionalOutput = Optional.of(new Task(1L, "go shopping"));
		Task output = new Task(1L, "go shopping");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);
		
		assertEquals(output, this.service.getById(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
	
	@Test
	public void createTest() {
		Task input = new Task("go shopping");
		Task output = new Task(1L, "go shopping");
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}
	
	@Test
	public void updateTest() {
		Task input = new Task("go shopping");
		Optional<Task> existing = Optional.of(new Task(1L, "go shopping"));
		Task output = new Task(1L, "clean house");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, this.service.update(1L, input));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
}