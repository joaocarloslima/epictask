package br.com.fiap.EpicTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "user not found")
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	
}
