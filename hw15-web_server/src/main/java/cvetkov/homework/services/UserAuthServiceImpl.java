package cvetkov.homework.services;


import cvetkov.homework.dao.UserDao;

public class UserAuthServiceImpl implements UserAuthService {

    private final UserDao userDao;

    public UserAuthServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean authenticate(String numberCard, String pineCide) {
        return userDao.findByNumberCard(numberCard)
                .map(user -> user.getPineCode().equals(pineCide))
                .orElse(false);
    }

}
