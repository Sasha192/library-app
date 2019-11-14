package mate.academy.spring.service.impl;

import java.util.List;

import mate.academy.spring.dao.AuthorDao;
import mate.academy.spring.entity.Author;
import mate.academy.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> listAuthor() {
        return authorDao.listAuthor();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List findByNameAndSurname(String name, String surname) {
        return authorDao.findByNameAndSurname(name, surname);
    }
}
