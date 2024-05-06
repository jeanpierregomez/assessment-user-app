package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUser(String id) {
        return userRepository.getUser(id);
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }

    public User updateUser(User user) throws Exception {
        User userById = userRepository.getUser(user.getId());
        if (userById == null) {
            throw new Exception("El usuario no existe");
        } else {
            userById.setUsername(user.getUsername());
            userById.setEmail(user.getEmail());
            userById.setAge(user.getAge());
            return userRepository.saveUser(userById);
        }
    }

    public User updateBalance(String id, BigDecimal balance) throws Exception {
        User userById = userRepository.getUser(id);
        if (userById == null) {
            throw new Exception("El usuario no existe");
        } else {
            userById.setBalance(balance);
            return userRepository.saveUser(userById);
        }
    }

}
