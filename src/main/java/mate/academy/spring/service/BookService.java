package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;

public interface BookService {
    void add(Book user);

    List<Book> listBooks();

    Optional<Book> findById(Long id);

    List<Book> findByTitle(String title);

    void deleteBookById(Long id);
}
