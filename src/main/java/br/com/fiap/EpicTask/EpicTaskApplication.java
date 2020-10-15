package br.com.fiap.EpicTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EpicTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpicTaskApplication.class, args);
	}
	

}
