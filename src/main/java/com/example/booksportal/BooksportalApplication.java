package com.example.booksportal;

import com.example.booksportal.dao.DaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksportalApplication implements CommandLineRunner {

	@Autowired
	private DaoUser userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BooksportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
