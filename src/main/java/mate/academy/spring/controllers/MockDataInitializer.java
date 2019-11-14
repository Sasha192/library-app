package mate.academy.spring.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.spring.entity.Author;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.AuthorService;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.RoleService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/init")
public class MockDataInitializer {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private RentService rentService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(ModelMap modelMap) {
        User[] users = new User[4];
        users[0] = new User("Sunil", "Bora", "suni.bora@example.com");
        users[1] = new User("David", "Miller", "david.miller@example.com");
        users[2] = new User("Sameer", "Singh", "sameer.singh@example.com");
        users[3] = new User("Paul", "Smith", "paul.smith@example.com");

        for (int i = 0; i < 4; i++) {
            List<Role> roles = users[i].getRoles();
            if (roles == null) {
                Optional<Role> roleUser = roleService.getRoleByName("ROLE_USER");
                Role role = roleUser.orElseThrow(NoSuchElementException::new);
                roles = new ArrayList<>();
                roles.add(role);
                users[i].setRoles(roles);
            }
        }

        Author[] authors = new Author[4];

        authors[0] = new Author("Author NAME _ 1", "Author Surname _ 1");
        authors[1] = new Author("Author NAME _ 2", "Author Surname _ 2");
        authors[2] = new Author("Author NAME _ 3", "Author Surname _ 3");
        authors[3] = new Author("Author NAME _ 4", "Author Surname _ 4");

        Book[] books = new Book[8];

        books[0] = new Book("War & Peace", 25., null);
        books[1] = new Book("Physics", 24., null);
        books[2] = new Book("Mechanics", 23., null);
        books[3] = new Book("Tanos", 22., null);

        for (int i = 0; i < 4; i++) {
            books[i].setAuthors(Arrays.asList(new Author[]{authors[i]}));
            for (int j = 0; j < i + 1; j++) {
                authors[j].addBook(books[i]);
            }
        }

        for (int i = 0; i < 4; i++) {
            userService.add(users[i]);
            authorService.add(authors[i]);
            bookService.add(books[i]);
            rentService.add(new Rent(LocalDate.now(), users[i], books[i]));
        }
        return "redirect:/";
    }
}
