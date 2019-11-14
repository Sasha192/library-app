package mate.academy.spring.controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private RentService rentService;

    @RequestMapping(method = RequestMethod.GET, value = "/rent_book")
    public String rentBook(ModelMap modelMap, @RequestParam("book_id") Long bookId,
                           Principal principal) {
        Optional<User> userOptional = userService.findByEmail(principal.getName());
        Optional<Book> bookOptional = bookService.findById(bookId);
        if (bookOptional.isEmpty() || userOptional.isEmpty()) {
            return "error";
        }
        Rent rent = new Rent();
        rent.setBook(bookOptional.get());
        rent.setUser(userOptional.get());
        rent.setRentDate(LocalDate.now());
        rentService.add(rent);
        return "redirect:/book";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_list")
    public String rentList(ModelMap modelMap, Principal principal) {
        Optional<User> userOptional = userService.findByUsername(principal.getName());
        if (userOptional.isEmpty()) {
            return "error";
        }
        modelMap.addAttribute("rent_list", rentService.listRents(userOptional.get().getId()));
        return "rentBooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/return_book")
    public String returnBook(ModelMap modelMap, @RequestParam("book_id") Long bookId,
                             Principal principal) {
        Optional<User> userOptional = userService.findByUsername(principal.getName());
        Optional<Book> bookOptional = bookService.findById(bookId);
        if (bookOptional.isEmpty() || userOptional.isEmpty()) {
            return "error";
        }
        rentService.returnBook(bookOptional.get().getId(), userOptional.get().getId());
        return "redirect:/rent/get_list";
    }
}
