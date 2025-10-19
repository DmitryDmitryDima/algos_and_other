package language.multithreading;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class CyclicBarrierExample {


    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(2, ()->{
            try {
                System.out.println("Special action executed after barrier release -  start");
                Thread.sleep(1000);
                System.out.println("Special action executed after barrier release -  finish");
            }
            catch (InterruptedException e){

            }
        });

        // на середине выполнения задачи потоки буду ждать, пока все остальные достигнут барьера
        // после этого они продолжат работу, а также выполнится специальное задание, прописанное в барьере
        Runnable workerTask = ()->{
            try {
                System.out.println(Thread.currentThread().getName()+" starts his work");
                for (int i = 0; i<10; i++){
                    if (i==5){
                        System.out.println(Thread.currentThread().getName()+" is waiting");
                        barrier.await();
                    }

                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000,10000));

                }

                System.out.println(Thread.currentThread().getName()+" finishes his work");


            }
            catch (Exception e){

            }


        };

        Thread worker1 = new Thread(workerTask);
        Thread worker2 = new Thread(workerTask);

        try {
            worker1.start();
            worker2.start();
            worker1.join();
            worker2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
