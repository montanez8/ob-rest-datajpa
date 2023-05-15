package com.montanez.company.obrestdatajpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name ="books")
@ApiModel("Entidad libro")
public class Book {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria id TYpe Long")
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
    //constructor

    public Book(Long id) {
        this.id = id;
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public Book() {

    }
    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


}
