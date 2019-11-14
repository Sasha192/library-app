
package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Book", Book.class);
        return query.getResultList();
    }

    @Override
    public Optional<Book> findById(Long id) {
        TypedQuery<Book> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Book WHERE id=:id", Book.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Book WHERE title LIKE CONCAT('%', :title, '%')", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = new Book();
        book.setId(id);
        sessionFactory.getCurrentSession().delete(book);
    }
}
