package com.security.example;

import com.security.example.user.User;
import com.security.example.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count()==0){
			// Khi chương trình chạy
			// Insert vào csdl một user.
			User user = new User();
			user.setUsername("loda");
			user.setPassword(passwordEncoder.encode("loda"));
			userRepository.save(user);
			System.out.println(user);
		}
	}

}
