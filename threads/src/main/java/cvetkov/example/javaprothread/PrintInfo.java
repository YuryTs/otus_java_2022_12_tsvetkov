package cvetkov.example.javaprothread;

public class PrintInfo {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()); //имя потока
        System.out.println("---------------");
        thread.setName("new-main-thread-name"); //устанавливаем новое имя потока
        System.out.println("Name : " + thread.getName());//выводим новое имя потока
        System.out.println("Id : " + thread.getId()); //номер потока
        System.out.println("Priority : " + thread.getPriority()); //приоритет
        System.out.println("State : " + thread.getState()); //состояние
    }
}
