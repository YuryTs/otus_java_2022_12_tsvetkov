package cvetkov.homework.dao;



import cvetkov.homework.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserDao implements UserDao {

    private final Map<Long, User> users;

    public InMemoryUserDao() {
        users = new HashMap<>();
        users.put(1L, new User(1L, "123",  "11111"));
        users.put(2L, new User(2L, "456",  "11111"));
        users.put(3L, new User(3L, "789",  "11111"));

    }

    @Override
    public Optional<User> findByNumberCard(String login) {
        return users.values().stream().filter(v -> v.getNumberCard().equals(login)).findFirst();
    }
}
