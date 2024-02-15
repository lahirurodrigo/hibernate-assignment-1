package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int a_id;
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author() {
    }

    public Author(int a_id, String name, List<Book> bookList) {
        this.a_id = a_id;
        this.name = name;
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
                "id='" + a_id + '\'' +
                ", name='" + name + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
