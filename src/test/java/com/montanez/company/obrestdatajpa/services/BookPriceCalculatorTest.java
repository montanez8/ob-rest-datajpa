package com.montanez.company.obrestdatajpa.services;

import com.montanez.company.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {
Book book = new Book(null, "El señor de los anillos", "J.R.R Tolkien", 1200, 49.99, null);
    @Test
     void calculatePrice() {//metodo que calcula el precio del libro
        BookPriceCalculator calculator = new BookPriceCalculator();//creamos un objeto de la clase BookPriceCalculator
       double price =calculator.calculatePrice(book);
        System.out.println(price);
        assertTrue( price>0);
    }

}