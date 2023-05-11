package ru.otus.exeption;

public class RefflectionJdbcExeption extends RuntimeException{
    public RefflectionJdbcExeption(String message, Throwable cause){
        super(message, cause);
    }
    public RefflectionJdbcExeption(String message){
        super(message);
    }
}
