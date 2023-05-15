package com.montanez.company.obrestdatajpa.services;

import com.montanez.company.obrestdatajpa.entities.Book;

public class BookPriceCalculator {

    //calculePrice
    public Double calculatePrice(Book book){
        double price = book.getPrice();

        if(book.getPages() > 300){
            price +=5;
        }
        price += 2.99;
        return price;
    }
}
