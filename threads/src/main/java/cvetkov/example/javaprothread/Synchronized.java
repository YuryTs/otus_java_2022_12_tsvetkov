package cvetkov.example.javaprothread;

public class Synchronized {

    public static int count;
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
//        syncDemo();
//        syncNotWorkDemo();
        syncMethodDemo();
    }

    private static void syncDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) { //обернули в объект на котором синхронизация  (так называемый монитор) синхронизироваться можно на любом объекте
                    count++;
                }
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    count++;
                }
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count);
    }

    private static void syncNotWorkDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (new Object()) { //на новом объекте не приведет к синхронизации
                    count++;
                }
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (new Object()) {
                    count++;
                }
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count);
    }

    public static synchronized void increment() { //создали синхронайзд метод, который потом вызываем
        count++;
    }

    public static void syncMethodDemo() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (object) {
                    increment();
                }
            }
        });

        t0.start();
        t1.start();

//        Если не добавить join(), то будет распечатан близкий к 0 результат
        t0.join();
        t1.join();

        System.out.println("Count = " + count);
    }
}
