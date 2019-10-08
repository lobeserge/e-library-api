package com.elibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.elibrary.model.Book;
import com.elibrary.repository.BookRepository;


@Component
@Order(2)
public class BookRepositoryCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book(1,"14562622","java code geeks","lobe serge","ambooks","english");
		Book book1 = new Book(2,"14562622","jsf tutorials","lobe serge","ambooks","english");
		Book book2 = new Book(3,"14562622","spring  and hibernate","rica rita","ambooks","english");
		Book book3 = new Book(4,"14562622","hibernate endgame","jacob frank","ambooks","english");
		
		bookRepository.save(book);
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
	}

	
}
