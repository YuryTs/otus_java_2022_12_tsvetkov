package cvetkov.homework.behavioral.memento2;

import java.util.Date;

public class Save { //сущность которая будет сохранять состояние объекта (project)
    private final String versin; //обрати внимание что поля final
    private final Date date;

    public Save(String versin) {
        this.versin = versin;
        this.date = new Date();
    }

    public String getVersin() {
        return versin;
    }

    public Date getDate() {
        return date;
    }
}
