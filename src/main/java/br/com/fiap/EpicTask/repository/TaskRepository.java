package br.com.fiap.EpicTask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.EpicTask.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByStatusLessThan(int status);
	
	

}
