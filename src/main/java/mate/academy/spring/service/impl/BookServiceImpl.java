package mate.academy.spring.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.dao.BookDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> findById(Long id) {
        return bookDao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        bookDao.deleteBookById(id);
    }
}
