
package mate.academy.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;

import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Rent;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory
                .getCurrentSession()
                .save(rent);
    }

    @Override
    public List<Rent> listRents(Long userId) {
        TypedQuery<Rent> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Rent WHERE active = true AND user_id=:user_id", Rent.class);
        query.setParameter("user_id", userId);
        return query.getResultList();
    }

    @Override
    public void returnBook(Long bookId, Long userId) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Rent rent SET active = false"
                        + " WHERE user_id=:userId AND book_id=:bookId");
        query.setParameter("userId", userId);
        query.setParameter("bookId", bookId);
        query.executeUpdate();
    }
}
