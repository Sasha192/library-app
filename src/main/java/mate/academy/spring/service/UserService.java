package mate.academy.spring.service;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String name);
}
