package br.com.fiap.EpicTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.EpicTask.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
