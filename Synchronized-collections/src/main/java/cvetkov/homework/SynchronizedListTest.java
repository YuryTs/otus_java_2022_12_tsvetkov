package cvetkov.homework;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class SynchronizedListTest {
    public static int SIZE = 10000;

    public static void main(String[] args) throws Exception {

        Random random = new Random();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        CyclicBarrier barrier = new CyclicBarrier(3);


        Thread insert1 = new Thread(() -> { //один поток будет стартовать
            waitAnother(barrier);
            for (int i = 0; i < SIZE; i++) {
                insert(list, random.nextInt(100));
            }
        });

//можно записать и так
//        new Thread(() -> {
//            for (int i = 0; i < SIZE; i++) {
//                insert(list, random.nextInt(100));
//            }
//        }).start();

//можно записать и так поменять на лямду
//        new Thread((new Runnable() {
//            @Override
//            public void run() {
//            }
//        })).start();
        Thread insert2 = new Thread(() -> { //один поток будет стартовать
            waitAnother(barrier);
            for (int i = 0; i < SIZE; i++) {
                insert(list, random.nextInt(100));
            }
        });

        Thread read = new Thread(() -> { //второй поток будет печатать список
            waitAnother(barrier);
            list.forEach(JustListTest::print); //forEach более безопасная и более защищенная чем обычная итерация
//            for (int i = 0; i < list.size(); i++) {
//                print(list.get(i));
//            }
        });

//        new Thread(() -> { //второй поток будет печатать список
//            for (int i = 0; i < SIZE; i++) {
//                print(list.get(i));
//            }
//        }).start();

        insert1.start();
        insert2.start();
        read.start();

        read.join();
        insert1.join();
        insert2.join();


        System.out.println("list size = " + list.size());

        Thread.sleep(10000);
    }

    public static <T> void insert(List<T> list, T item){
        list.add(item);
    }

    public static <T> void print(T item){
        System.out.println(item);
    }

    public static void waitAnother(CyclicBarrier barrier){ //CyclicBarrier работает так: у него есть какое то количество и любой трейд заходящий в этот барьер уменьшает его на 1 типо ограничения вхождения потоков
        try{
            barrier.await();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }

    }

}
