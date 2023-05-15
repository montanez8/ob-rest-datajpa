package com.montanez.company.obrestdatajpa.controller;

import com.montanez.company.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {
    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    void findAllBooks() {
        ResponseEntity<Book[]> response =
                testRestTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(HttpStatus .OK, response.getStatusCode());

        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());


    }

    @Test
    void findBookById() {
        ResponseEntity<Book> response =
                testRestTemplate.getForEntity( "/api/books/1" ,Book.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
@DisplayName("Create a new book")
    @Test
    void createBook() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String json= """
                {
                "title": "El señor de los anillos 2",
                    "author": "J.R.R Tolkien",
                    "pages": 1200,
                    "price": 1500,
                    "releaseDate": null
                }
                         z""";

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Book> response =
        testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);
        Book result = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("El señor de los anillos 2", result.getTitle());
        assertEquals(1500, result.getPrice());

    }
}