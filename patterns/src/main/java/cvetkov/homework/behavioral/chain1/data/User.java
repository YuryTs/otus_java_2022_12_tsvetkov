package cvetkov.homework.behavioral.chain1.data;

public class User {

    private String name;
    private String passwd;
    private Realm realm; //авиторизационный круг (домен) к которому юзер относится

    public User(final String name, final String passwd, final Realm realm) {
        this.name = name;
        this.passwd = passwd;
        this.realm = realm;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(final String passwd) {
        this.passwd = passwd;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(final Realm realm) {
        this.realm = realm;
    }
}
