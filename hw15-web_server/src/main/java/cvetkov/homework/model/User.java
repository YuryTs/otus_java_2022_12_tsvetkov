package cvetkov.homework.model;

public class User {

    private final long id;
    private final String numberCard;
    private final String pineCode;

    public User(long id, String numberCard, String password) {
        this.id = id;
        this.numberCard = numberCard;
        this.pineCode = password;
    }

    public long getId() {
        return id;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public String getPineCode() {
        return pineCode;
    }


}
