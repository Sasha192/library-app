package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.entity.Rent;

public interface RentService {
    void add(Rent rent);

    List<Rent> listRents(Long userId);

    void returnBook(Long bookId, Long userId);
}
