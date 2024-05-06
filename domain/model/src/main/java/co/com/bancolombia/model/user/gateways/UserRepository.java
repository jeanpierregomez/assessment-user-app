package co.com.bancolombia.model.user.gateways;

import co.com.bancolombia.model.user.User;

import java.util.List;

public interface UserRepository {

    public User saveUser(User user);
    public void deleteUser(String id);
    public User getUser(String id);
    public List<User> getUsers();
}
