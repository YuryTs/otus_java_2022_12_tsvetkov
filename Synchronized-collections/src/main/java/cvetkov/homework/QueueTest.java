package cvetkov.homework;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(1000);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        for (int i = 0; i < 3; i++) {
            System.out.println(queue.poll()); //pool - Извлекает и удаляет заголовок этой очереди или возвращает значение NULL, если эта очередь пуста.
        }
    }
}
