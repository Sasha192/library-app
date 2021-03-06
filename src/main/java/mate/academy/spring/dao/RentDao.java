package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.entity.Rent;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents(Long userId);

    void returnBook(Long bookId, Long userId);
}
