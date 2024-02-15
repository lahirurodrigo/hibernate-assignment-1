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
        author.setName("Heisenberg");
        author.setCounntry("Denmark");

        Book book = new Book();
        //book.setId(1);
        book.setTitle("Reality of Freedom");
        book.setYear(Year.of(2016));
        book.setPrice(2000);
        book.setAuthor(author);

        bookList.add(book);

        author.setBookList(bookList);

        session.save(author);
        session.save(book);*/

        /*Author dummy = session.load(Author.class,352);

        Book book = new Book();
        book.setTitle("Freedom For All");
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

        //int query2 = session.createQuery("UPDATE Book SET price = price+price*0.1 WHERE author.id = 52").executeUpdate();

        // Question 3
        // For quetion 3 i added attribute cascade = CascadeType.Remove to @OneToMany

        //Qusestion 4

        Double average = session.createQuery("SELECT avg(price) FROM Book", Double.class).getSingleResult();
        System.out.println(average);

        // Question 5

        List<Object[]> list = session.createQuery("SELECT author,count(id) FROM Book GROUP BY author.a_id").getResultList();
        for (Object[] o : list) {
            //System.out.println(o[0]);
            //System.out.println(o[1]);
        }

        // Question 6

        List<Book> resultList = session.createQuery("FROM Book WHERE author.counntry = 'Denmark'").getResultList();
        for (Book b : resultList) {
            System.out.println(b.getTitle());
        }

        // Question 7
        /*
        In Author Class
        @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
        private List<Book> bookList;

        In Book Class

        @ManyToOne
        @JoinColumn(name = "author_id")
        private Author author;

         */

        // Question 10

        List<Author> specAuthors = session.createQuery("SELECT a FROM Author a WHERE size(a.bookList) > " +
                "(SELECT AVG(size(b.bookList)) FROM Author b)", Author.class).list();

        transaction.commit();
        session.close();

    }
}