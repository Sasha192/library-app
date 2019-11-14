package mate.academy.spring.controllers;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllBooks(ModelMap modelMap) {
        List<Book> books = bookService.listBooks();
        modelMap.addAttribute("allBooks", books);
        return "allBooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getBookInfoById(ModelMap modelMap, @PathVariable("id") Long id) {
        Optional<Book> book = bookService.findById(id);
        book.ifPresent(value -> modelMap.addAttribute("book", value));
        return "bookInfo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public String findByTitle(@RequestParam String title, ModelMap modelMap) {
        modelMap.put("allBooks", bookService.findByTitle(title));
        return getAllBooks(modelMap);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String addBookPage(ModelMap modelMap) {
        return getAllBooks(modelMap);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addBook(@ModelAttribute Book book, ModelMap modelMap) {
        bookService.add(book);
        return getAllBooks(modelMap);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long id, ModelMap modelMap) {
        bookService.deleteBookById(id);
        return getAllBooks(modelMap);
    }
}
