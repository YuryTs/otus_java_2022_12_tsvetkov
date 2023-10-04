package ru.otus.sessionmanager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionManagerSpring implements TransactionManager {


    @Override
    @Transactional //если метод помечен этой аннотацией
    public <T> T doInTransaction(TransactionAction<T> action) {
        return action.get();
    }
}
