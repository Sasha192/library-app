package mate.academy.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.validation.Valid;

import mate.academy.spring.dto.UserRegistrationDto;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RoleService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String addUserPage() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addUser(@ModelAttribute @Valid UserRegistrationDto user, BindingResult result) {
        User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()),
                user.getFirstName(), user.getLastName(), user.getEmail());
        List<Role> roles = newUser.getRoles();
        if (roles == null) {
            Optional<Role> roleUser = roleService.getRoleByName("ROLE_USER");
            Role role = roleUser.orElseThrow(NoSuchElementException::new);
            roles = new ArrayList<>();
            roles.add(role);
            newUser.setRoles(roles);
        }
        if (result.hasErrors()) {
            return "error";
        }
        userService.add(newUser);
        return "login";
    }
}
