package language.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class MultithreadingSynchronized {

    public static final Object lock = new Object();
    public static Thread t1;
    public static Thread t2;

    public static Runnable task = ()->{
        while (true) {
            int r = ThreadLocalRandom.current().nextInt(1000,5000);


            // синхронизированный блок может выполняться только одним потоком - ожидающий поток будет иметь blocked state
            synchronized (lock){
                try {
                    System.out.println(Thread.currentThread().getName()+" starts execution");
                    System.out.println(t1.getName()+" "+t1.getState());
                    System.out.println(t2.getName()+" "+t2.getState());
                    Thread.sleep(r);
                    System.out.println(Thread.currentThread().getName()+" ends execution");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    };

    public static void main(String[] args) {
        /*
        t1 = new Thread(task);
        t2 = new Thread(task);
        t1.setName("First thread");
        t2.setName("Second thread");

        t1.start();
        t2.start();

         */

        new Thread(()->{
            while (true){
                test();
            }
        }, "First").start();

        new Thread(()->{
            while (true){
                test();
            }
        }, "Second").start();


    }


    public static synchronized void test(){
        try {
            int r = ThreadLocalRandom.current().nextInt(1000,5000);
            System.out.println(Thread.currentThread().getName()+" starts execution");
            Thread.sleep(r);
            System.out.println(Thread.currentThread().getName()+" ends execution");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
