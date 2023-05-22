package com.montanez.company.obrestdatajpa;

import com.montanez.company.obrestdatajpa.entities.Book;
import com.montanez.company.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		//crear un libro
		Book book = new Book(null, "El señor de los anillos", "J.R.R Tolkien", 1200, 1900.0, null);
		Book book2 = new Book(null, "El señor de los anillos v2", "J.R.R Tolkien", 2000, 1500.0, null);

		//guardar un libro
		System.out.println("Num loibros en la base de datos" + bookRepository.findAll().size());
		bookRepository.save(book);
		bookRepository.save(book2);

		System.out.println("Num loibros en la base de datos" + bookRepository.findAll().size());
		//buscar un libro
		Book book1 = bookRepository.findById(1L).orElse(null);

		System.out.println("Num loibros en la base de datos" + bookRepository.findAll().size());
		//actualizar un libro
		book1.setPrice(1500.0);
		bookRepository.save(book1);

		//eliminar un libro
		//bookRepository.delete(book1);

		System.out.println("Num loibros en la base de datos" + bookRepository.findAll().size());


	}

	}


