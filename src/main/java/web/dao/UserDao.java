package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> showAll();

    public void save(User user);

    public void update(long id, User updatedUser);

    public void delete(long id);

    public User showUser(long id);

}




