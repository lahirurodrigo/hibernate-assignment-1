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
        author.setName("Jhonson");

        Book book = new Book();
        //book.setId(1);
        book.setTitle("Freedom fighters");
        book.setYear(Year.of(2016));
        book.setPrice(1800);
        book.setAuthor(author);

        bookList.add(book);

        author.setBookList(bookList);

        session.save(author);
        session.save(book);*/

        /*Author dummy = session.load(Author.class,52);

        Book book = new Book();
        book.setTitle("Real Freedom");
        book.setYear(Year.of(2014));
        book.setPrice(1000);
        book.setAuthor(dummy);

        session.save(book);*/

        // Question 1

        Query query = session.createQuery("FROM Book WHERE year > ?1");
        query.setParameter(1,Year.of(2010));
        List<Book> books = query.getResultList();

        for (Book b:books) {
            System.out.println(b.getTitle());
        }

        // Question 2

        int query2 = session.createQuery("UPDATE Book SET price = price+price*0.1 WHERE author.id = 52").executeUpdate();

        // Question 3


        transaction.commit();
        session.close();

    }
}