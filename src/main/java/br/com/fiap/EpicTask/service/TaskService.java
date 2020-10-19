package br.com.fiap.EpicTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import br.com.fiap.EpicTask.model.Task;
import br.com.fiap.EpicTask.model.User;
import br.com.fiap.EpicTask.repository.TaskRepository;
import br.com.fiap.EpicTask.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@CacheEvict(value = "users", allEntries = true)
	public void update(Task task) {
		repository.save(task);
		if (task.getStatus() == 100) {
			User user = task.getUser();
			int point = task.getPoint();
			user.toScore(point);
			userRepository.save(user);
		}
	}

	public List<Task> findPendenting() {
		return repository.findByStatusLessThan(100);
	}
	

	
	
	
	
}
