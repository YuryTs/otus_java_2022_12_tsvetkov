package cvetkov.homework.behavioral.chain2;

import java.util.ArrayList;
import java.util.List;

class Application {
    private final List<String> history = new ArrayList<>(); //истрория прохождения

    void addHistoryRecord(String historyRecord) { //добавить запись в историю
        history.add(historyRecord);
    }

    void printHistory() { //распечатать историю
        System.out.println(history);
    }
}
