package mate.academy.spring.service.impl;

import java.util.List;

import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public void add(Rent rent) {
        rentDao.add(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> listRents(Long userId) {
        return rentDao.listRents(userId);
    }

    @Transactional
    @Override
    public void returnBook(Long bookId, Long userId) {
        rentDao.returnBook(bookId, userId);
    }
}
