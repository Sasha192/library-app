package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> listBooks();

    Optional<Book> findById(Long id);

    List<Book> findByTitle(String title);

    void deleteBookById(Long id);
}
