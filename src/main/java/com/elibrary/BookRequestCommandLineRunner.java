package com.elibrary;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elibrary.model.Book;
import com.elibrary.model.Book_Request;
import com.elibrary.model.User;
import com.elibrary.repository.Book_Request_Repository;


@Component
@Order(3)
public class BookRequestCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	Book_Request_Repository bookRequestRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Book_Request bookrequest = new Book_Request();
		bookrequest.setId(1);
		bookrequest.setRequest_time(new Date().toString());
		bookrequest.setResponse_time("");
		bookrequest.setStatus(0);
		bookrequest.setBookId(new Book(2));
		bookrequest.setUserId(new User(1));
		bookRequestRepository.save(bookrequest);
		
		
		Book_Request bookrequest2 = new Book_Request();
		bookrequest2.setId(2);
		bookrequest2.setRequest_time(new Date().toString());
		bookrequest2.setResponse_time("");
		bookrequest2.setStatus(0);
		bookrequest2.setBookId(new Book(3));
		bookrequest2.setUserId(new User(1));
		bookRequestRepository.save(bookrequest2);
		
		
		Book_Request bookrequest3 = new Book_Request();
		bookrequest3.setId(3);
		bookrequest3.setRequest_time(new Date().toString());
		bookrequest3.setResponse_time("");
		bookrequest3.setStatus(0);
		bookrequest3.setBookId(new Book(4));
		bookrequest3.setUserId(new User(2));
		bookRequestRepository.save(bookrequest3);
		
		Book_Request bookrequest4 = new Book_Request();
		bookrequest4.setId(4);
		bookrequest4.setRequest_time(new Date().toString());
		bookrequest4.setResponse_time("");
		bookrequest4.setStatus(1);
		bookrequest4.setBookId(new Book(3));
		bookrequest4.setUserId(new User(2));
		bookRequestRepository.save(bookrequest4);
		
	}

	
}
