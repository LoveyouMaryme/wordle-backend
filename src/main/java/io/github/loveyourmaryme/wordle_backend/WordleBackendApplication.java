package io.github.loveyourmaryme.wordle_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WordleBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordleBackendApplication.class, args);
	}

	@GetMapping
	public String helloWorld(){
		return "Hello World Spring";
	}

}
