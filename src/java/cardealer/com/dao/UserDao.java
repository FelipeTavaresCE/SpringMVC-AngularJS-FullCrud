package cardealer.com.dao;

import cardealer.com.model.User;

public interface UserDao {

    public boolean createUser(User user);
    public User loginUser(User user);
}
