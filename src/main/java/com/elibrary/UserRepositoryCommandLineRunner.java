package com.elibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elibrary.model.Book;
import com.elibrary.model.User;
import com.elibrary.repository.BookRepository;
import com.elibrary.repository.UserRepository;


@Component
@Order(1)
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User(1,"lobe","serge","nyoh");
		User user1 = new User(2,"riri","sita","matta");
		User user2 = new User(3,"lili","lala","lali");
		
		
		userRepository.save(user);
		userRepository.save(user1);
		userRepository.save(user2);
		
	}

	
}
