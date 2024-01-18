package com.example.booksportal.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@Entity
@Table(name = "Libri")
public class Book {

    @NonNull
    @Size(min=2, max=20)
    private String title;

    @NonNull
    @Size(min=2, max=20)
    private String author;

    @NonNull
    @Size(min=2, max=20)
    private String releaseYear;

    @NonNull
    @Size(min=2, max=20)
    private String price;

    @NonNull
    @Size(min=2, max=20)
    private String publisher;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Book() {
    }

    public Book(@NonNull String title, @NonNull String author, @NonNull String releaseYear, @NonNull String price, @NonNull String publisher) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.price = price;
        this.publisher = publisher;
        //this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

    @NonNull
    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(@NonNull String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @NonNull
    public String getPrice() {
        return price;
    }

    public void setPrice(@NonNull String price) {
        this.price = price;
    }

    @NonNull
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(@NonNull String publisher) {
        this.publisher = publisher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", price='" + price + '\'' +
                ", publisher='" + publisher + '\'' +
                ", id=" + id +
                '}';
    }
}
