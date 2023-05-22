package com.montanez.company.obrestdatajpa.controller;

import com.montanez.company.obrestdatajpa.entities.Book;
import com.montanez.company.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")//ruta de la api
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }
    //buscar todos los libros
    @GetMapping
    public List<Book> findAllBooks() {
        return repository.findAll();
    }
    //buscar un solo libro por Id
    @GetMapping("/{id}")
    @ApiOperation("Devuelve un libro por su id llave primaria")
    public ResponseEntity<Book> findBookById(@ApiParam("Clave primaria id TYpe Long") @PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //añadir un libro nuevo a la base de datos
    @PostMapping
    public Object createBook(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (book.getId() != null) {
            log.warn("Trying to create a new book with existent id {}", book.getId());
            throw new RuntimeException("Id already exists");
        }

        Book result = repository.save(book);
        return ResponseEntity.ok(result).getBody();
    }

    //actualizar un libro
    @PutMapping//se pone él, id del libro que se quiere actualizar
    public Book update(@RequestBody Book book){
        if (!repository.existsById(book.getId())){//si no existe el libro
            log.warn("Trying to update a book without id");//se lanza una exception
            throw new RuntimeException("Id not found");//
        }
        Book result = repository.save(book);//si existe se guarda el libro
        return  ResponseEntity.ok(result).getBody();

    }

    //eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        if (!repository.existsById(id)){//si no existe el libro
            return ResponseEntity.ok().build();//se devuelve un ok
    }
        return ResponseEntity.noContent().build();//si existe elimina el libro
    }

    //eliminar todos los libros
    @DeleteMapping
    public ResponseEntity<Void> deleteAllBooks() {//se elimina todos los libros
        repository.deleteAll();
        return ResponseEntity.noContent().build();
     }

}
