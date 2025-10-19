package language.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserThread {

    public static void main(String[] args) {




        Phaser phaser = new Phaser(1); // главный поток - тоже участник, поэтому ставим единицу (регистрируем)


        // потоки с задачей в несколько фаз
        class Worker implements Runnable {



            Worker(){

                phaser.register(); // РЕГИСТРАЦИЯ ПРОИСХОДИТ ПЕРЕД ЗАПУСКОМ
            }

            @Override
            public void run() {


                System.out.println(Thread.currentThread().getName()+" starts phase 1");

                phaser.arriveAndAwaitAdvance();

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){

                }

                System.out.println(Thread.currentThread().getName()+" starts phase 2");

                phaser.arriveAndAwaitAdvance();

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){

                }

                System.out.println(Thread.currentThread().getName()+" starts phase 3");

                phaser.arriveAndDeregister();
            }
        }





        Thread thread1 = new Thread(new Worker());
        thread1.setName("A");


        Thread thread2 = new Thread(new Worker());
        thread2.setName("B");




        thread1.start();
        thread2.start();




        System.out.println("all starts phase 1");
        phaser.arriveAndAwaitAdvance();

        System.out.println("all starts phase 2");
        phaser.arriveAndAwaitAdvance();

        System.out.println("all starts phase 3")
        ;

        phaser.arriveAndDeregister(); // отключаем главный поток от phaser - конец выполнения









    }
}
