package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        System.out.println("!!");
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> showAll() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User toBeUpdated = session.get(User.class, id);

        toBeUpdated.setFirstName(updatedUser.getFirstName());
        toBeUpdated.setLastName(updatedUser.getLastName());
        toBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }

    @Override
    public User showUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
