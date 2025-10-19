package language.multithreading;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    private final Semaphore semaphore = new Semaphore(1); // только один поток может иметь доступ к ресурсу в моменте - другой будет ждать

    private long resource = 0;

    public static void main(String[] args) throws InterruptedException {

        SemaphoreExample semaphoreExample = new SemaphoreExample();

        Runnable r = ()->{
            int innerCount = 0;
            while (innerCount<1000000){
                try {


                    semaphoreExample.writeAccess();
                    innerCount++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(semaphoreExample.resource);

    }

    public void writeAccess() throws InterruptedException {
        try {
            semaphore.acquire();
            //semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS); допустим если нам критично время ожидания
            resource++;
        }
        finally {
            semaphore.release();
        }
    }

    // в обход семафора мы всегда будем получать разные значения resource - синхронизация отсутствует
    public void badAccess(){
        resource++;
    }



}
