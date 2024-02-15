package lk.ijse.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int a_id;
    private String name;
    private String counntry;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Author() {
    }

    public String getCounntry() {
        return counntry;
    }

    public void setCounntry(String counntry) {
        this.counntry = counntry;
    }

    public Author(int a_id, String name, String counntry, List<Book> bookList) {
        this.a_id = a_id;
        this.name = name;
        this.counntry = counntry;
        this.bookList = bookList;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "a_id=" + a_id +
                ", name='" + name + '\'' +
                ", counntry='" + counntry + '\'' +
                '}';
    }
}
