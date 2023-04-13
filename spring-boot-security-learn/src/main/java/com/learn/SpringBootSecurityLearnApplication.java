package com.learn;

import com.learn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//public class SpringBootSecurityLearnApplication implements CommandLineRunner {
public class SpringBootSecurityLearnApplication {

//	@Autowired
//	private UserRepo userRepo;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception
//	{
//		User user = new User();
//		user.setEmail("vijay@gmail.com");
//		user.setUsername("vijay");
//		user.setPassword(this.passwordEncoder.encode("vijay"));
//		user.setRole("USER");
//		this.userRepo.save(user);
//		User user1 = new User();
//		user1.setEmail("niraj@gmail.com");
//		user.setUsername("niraj");
//		user.setPassword(this.passwordEncoder.encode("niraj"));
//		user.setRole("ADMIN");
//		this.userRepo.save(user1);
//	}
}
