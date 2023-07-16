package com.fl0.surl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SurlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurlApplication.class, args);
	}

	@GetMapping("/hello")
	public String helloController(){
		return "Hello from springboot app !!";
	}

}
