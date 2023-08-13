package cvetkov.homework.dao;


import cvetkov.homework.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findByNumberCard(String login);
}