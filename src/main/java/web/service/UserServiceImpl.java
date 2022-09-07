package web.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        System.out.println("!!!");
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showAll() {
        System.out.println(userDao.showAll());
        return userDao.showAll();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User showUser(long id) {
        return userDao.showUser(id);
    }
    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }


    @Transactional
    @Override
    public void delete(long id) {userDao.delete(id);}


}
