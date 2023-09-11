package cvetkov.homework;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class MapTest {

    public static int SIZE = 10000;

    public static void main(String[] args) throws InterruptedException {

        Map<Integer, String> map = new ConcurrentHashMap<>();

        CyclicBarrier barrier = new CyclicBarrier(2);

        Set cuncurrentSet = map.keySet(); //


        Thread insert1 = new Thread(() -> { //один поток будет стартовать
            waitAnother(barrier);
            for (int i = 0; i < SIZE; i++) {
                insert(map, i);
            }
        });

        Thread insert2 = new Thread(() -> {
            for (int i = 10000; i < SIZE + 10000; i++) {
                insert(map, i);
            }
        });


        Thread read = new Thread(() -> { //второй поток будет печатать список
            waitAnother(barrier);
            map.keySet().forEach(JustListTest::print);
        });



        insert1.start();
        insert2.start();
        read.start();


        insert1.join();

        read.join();
        insert2.join();


        System.out.println("list size = " + map.size());
        Thread.sleep(10000);
    }


        public static <T> void insert (Map<T, String> map, T item){
            map.put(item, "");
        }

        public static <T> void print (T item){
            System.out.println(item);
        }
        public static void waitAnother(CyclicBarrier barrier) { //CyclicBarrier работает так: у него есть какое то количество и любой трейд заходящий в этот барьер уменьшает его на 1 типо ограничения вхождения потоков
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }


}
