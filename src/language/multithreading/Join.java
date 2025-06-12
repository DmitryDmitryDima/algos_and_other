package language.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class Join {

    public static final Runnable r = ()-> {
        try {
            System.out.println("inner thread start");
            Thread.sleep(ThreadLocalRandom.current().nextInt(4000, 6000));
            System.out.println("inner thread end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    };

    public static void main(String[] args) throws InterruptedException {
        viaJoin();


    }

    public static void viaJoin() throws InterruptedException{
        Thread t1 = new Thread(r);
        System.out.println("main thread starts inner thread and waits...");
        t1.start();
        t1.join();
        System.out.println("main thread continue to execute...");
    }


}
