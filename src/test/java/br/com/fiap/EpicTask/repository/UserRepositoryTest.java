package br.com.fiap.EpicTask.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fiap.EpicTask.model.User;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;

	@Test
	void shoultReturnAUserWhenSearchByEmail() {
		String email = "joao@gmail.com";
		Optional<User> search = repository.findByEmail(email);
		User user = search.get();
		assertNotNull(user);
		assertEquals(email, user.getEmail());
		
	}

}
