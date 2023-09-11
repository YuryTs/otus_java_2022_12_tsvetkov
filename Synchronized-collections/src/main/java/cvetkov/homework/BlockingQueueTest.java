package cvetkov.homework;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class BlockingQueueTest {

    static AtomicLong available = new AtomicLong(5);

    static LinkedBlockingQueue<Long> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        long timeout = 5000;

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                for (int i = 0; i < 50; i ++) { // 50 раз пытается запустить функцию consume
                    consume((long)i);
                    if (System.currentTimeMillis() - time > timeout) { //и считает таймаут, если 50 за это время не консьюмятся то все
                        throw new IllegalStateException("timeout");
                    }
                }
            }
        });

        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                available.decrementAndGet();
                Long item = null;

                do{
                    try {
                        item = queue.take();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    sleep(200);
                    System.out.println("consumer1 = " + item);
                } while (true);
            }
        });

        Thread consumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                available.decrementAndGet();
                Long item = null;

                do{
                    try {
                        item = queue.take();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    sleep(200);
                    System.out.println("consumer2 = " + item);
                } while (true);
            }
        });

        consumer1.start();
        consumer2.start();
        producer.start();
        sleep(200000);
//        producer.join();

    }

    public static void consume(long i)  {
        try {
            queue.put(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consumeInternal(Long item) { //приходит какое то значение
        while (available.intValue() < 1) { //есть ли доступные для обработки потоки
            Thread.yield(); //эта штука будет ждать пока один из потоков не освободиться
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                available.decrementAndGet(); //каждый поток когда запускается он при входе уменьшает количество потоков
                sleep(1000);
                System.out.println("consumed " + item);
                available.incrementAndGet(); //когда завершается увеличивает количество потоков
            }
        }).start();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
