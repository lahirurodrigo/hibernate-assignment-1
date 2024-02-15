package lk.ijse.entity;

import jakarta.persistence.*;

import java.time.Year;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private Year year;
    private double price;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(int id, String title, Year year, double price, Author author) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
