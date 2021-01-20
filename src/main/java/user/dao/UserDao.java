package user.dao;

import user.domain.User;

import java.util.List;

public interface UserDao {
    void add(final User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();
    void update(User user);
}
