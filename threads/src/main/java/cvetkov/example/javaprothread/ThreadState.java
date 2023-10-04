package cvetkov.example.javaprothread;

public class ThreadState {

    public static Thread t0;
    public static Thread t1;

    public static void main(String[] args) throws InterruptedException {
//        simpleDemoTask();
//        mediumDemoSolution();
//        mediumDemoTask();
//        hardDemoTask();
        hardDemoSolution();
    }

//    Задача: Необходимо распечатать статусы NEW, RUNNABLE, TERMINATED потока
    public static void simpleDemoTask() throws InterruptedException {
        Thread t0 = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        System.out.println("1 :" + t0.getState()); //new

        t0.start();
        System.out.println("2 :" + t0.getState()); //RUNNABLE

//        Thread.sleep(1);
        t0.join(); //гарантировано
        System.out.println("3 :" + t0.getState()); //TERMINATED

    }


    public static void simpleDemoSolution() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());

        t0.start();
        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());

        t0.join();
        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());
    }

    //    Задача: Необходимо распечатать статус TIME_WAITING потока
    public static void mediumDemoTask() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
           try{
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
        });

        System.out.println("t0 new :" + t0.getState());

        t0.start();
        System.out.println("t0 run :" + t0.getState());

        Thread.sleep(3000);
        System.out.println("t0 wait :" + t0.getState());



    }

    public static void mediumDemoSolution() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                System.out.println(Thread.currentThread().getName() + " : я заснул");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " : я проснулся");

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : меня разбудили когда спал");
            }
        });

        t0.start();

        System.out.println(Thread.currentThread().getName() + " : я заснул");
        Thread.sleep(3000); //проснулся раньше пока т0 спал
        System.out.println(Thread.currentThread().getName() + " : я проснулся");
        System.out.println(Thread.currentThread().getName() + " : поток " + t0.getName() + " в статусе " + t0.getState());
    }

//    Задача: Необходимо распечатать статус WAITING потока
    public static void hardDemoTask() throws InterruptedException {
        t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
        });

        t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t0.start();
        System.out.println(t0.getState());
        t1.start();
        t0.join();
        System.out.println(t0.getState());



    }

    public static void hardDemoSolution() throws InterruptedException {
        t0 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                System.out.println(Thread.currentThread().getName() + " : я заснул");
                t1.start();
                Thread.sleep(7000);
                System.out.println(Thread.currentThread().getName() + " : я проснулся");

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : меня разбудили когда спал");
            }
        });

        t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " : я стартовал");
            try {
                System.out.println(Thread.currentThread().getName() + " : я приостановился в ожидании");
                t0.join();
                System.out.println(Thread.currentThread().getName() + " : я дождался");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : меня разбудили когда спал");
            }
        });

        t0.start();
        System.out.println(Thread.currentThread().getName() + " : я заснул");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " : я проснулся");

        System.out.println(Thread.currentThread().getName() + " : поток " + t1.getName() + " в статусе " + t1.getState());
    }

}
