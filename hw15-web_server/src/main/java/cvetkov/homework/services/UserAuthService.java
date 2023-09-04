package cvetkov.homework.services;

public interface UserAuthService {
    boolean authenticate(String numberCard, String pineCode);
}
