
package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long userId) {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("FROM User WHERE id=:id",User.class);
        query.setParameter("id", userId);
        return query.getSingleResult();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE email=:email", User.class);
        query.setParameter("email", email);
        try {
            User user = query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE username=:username", User.class);
        query.setParameter("username", username);
        try {
            User user = query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
