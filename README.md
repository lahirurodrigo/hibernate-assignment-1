Question 1

Query query = session.createQuery("FROM Book WHERE year > ?1");
query.setParameter(1,Year.of(2010));
List<Book> books = query.getResultList();


Question 2

int query2 = session.createQuery("UPDATE Book SET price = price+price*0.1 WHERE author.id = 52").executeUpdate();


Question 3

For quetion 3 i added attribute cascade = CascadeType.Remove to @OneToMany 
@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
private List<Book> bookList;


Qusestion 4

Double average = session.createQuery("SELECT avg(price) FROM Book", Double.class).getSingleResult();


Question 5

List<Object[]> list = session.createQuery("SELECT author,count(id) FROM Book GROUP BY author.a_id").getResultList();


Question 6

List<Book> resultList = session.createQuery("FROM Book WHERE author.counntry = 'Denmark'").getResultList();


Question 7

In Author Class
@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
private List<Book> bookList;

In Book Class
        
@ManyToOne
@JoinColumn(name = "author_id")
private Author author;


Question 10

List<Author> specAuthors = session.createQuery("SELECT a FROM Author a WHERE size(a.bookList) > " +
    "(SELECT AVG(size(b.bookList)) FROM Author b)", Author.class).list();



Annotations used

@Entity
Annotation used to mark a Java class as a persistent entity. This means that instances of this class will be mapped to database tables. Indicates that the class is an entity and is managed by JPA.


@Id
Annotation used to mark a field or property of an entity class as the primary key. Indicates that the field or property is uniquely identifying each entity instance within the table.


@GeneratedValue
Annotation used to specify the generation strategy for the values of the primary key. Typically applied to the primary key field or property and indicates that the value of the primary key will be generated automatically by the persistence provider.

@OneToMany
Annotation used to define a one-to-many relationship between two entities. Indicates that one instance of the source entity (annotated with @OneToMany) can be associated with multiple instances of the target entity. Typically used to map a collection-valued attribute in the source entity that references multiple instances of the target entity.


@ManyToOne
Annotation used to define a many-to-one relationship between two entities. Indicates that many instances of the source entity can be associated with one instance of the target entity. Typically applied to a field or property in the source entity that represents the association with the target entity

@JoinColumn(author_id)
The @JoinColumn(name = "author_id") annotation in JPA is used to specify the name of the foreign key column in the database table that is associated with the owning side of the relationship. In the context of a one-to-many or many-to-one relationship, it's typically used on the owning side of the relationship.