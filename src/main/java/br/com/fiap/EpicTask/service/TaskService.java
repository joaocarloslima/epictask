package br.com.fiap.EpicTask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Task> findPending() {
		return repository.findByStatusLessThan(100);
	}
	
	public void create(Task task) {
		repository.save(task);
	}

	public void update(Task task) {
		repository.save(task);
		if (task.getStatus()==100) {
			User user = task.getUser();
			user.toScore(task.getPoint());
			userRepository.save(user);
		}
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Optional<Task> get(Long id) {
		return repository.findById(id);
	}

	public void take(Long idTask, User user) {
		Optional<Task> task = repository.findById(idTask);
		if (task.isPresent()) {
			Task newTask = task.get();
			if (newTask.getUser() == null) {
				newTask.setUser(user);
				repository.save(newTask);
			}
		}
	}

	public void drop(Long id, User user) {
		Optional<Task> task = repository.findById(id);
		if (task.isPresent()) {
			Task newTask = task.get();
			if (user.getEmail().equals(newTask.getUser().getEmail())) {
				newTask.setUser(null);
				repository.save(newTask);	
			}
		}

	}
	
}
