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

	public void update(Task task) {
		
		repository.save(task);
		if (task.getStatus()==100) {
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
