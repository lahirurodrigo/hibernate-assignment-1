package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        Session session = FactoryConfiguration.getInstance().getSessionFactory();
        Transaction transaction = session.beginTransaction();

        /*Author author = new Author();
        author.setName("Charles");

        Book book = new Book();
        book.setId(1);
        book.setTitle("Freedom");
        book.setYear(Year.of(2007));
        book.setPrice(1000);
        book.setAuthor(author);

        bookList.add(book);

        author.setBookList(bookList);

        session.save(author);
        session.save(book);*/

        /*Author dummy = session.load(Author.class,2);

        Book book = new Book();
        book.setTitle("Real Freedom");
        book.setYear(Year.of(2014));
        book.setPrice(1000);
        book.setAuthor(dummy);

        session.save(book);*/

        // Question 1

        Query query = session.createQuery("from Book where year > ?1");
        query.setParameter(1,Year.of(2010));
        List<Book> books = query.getResultList();

        // Question 2





        transaction.commit();
        session.close();

    }
}