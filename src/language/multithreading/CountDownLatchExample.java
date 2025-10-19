package language.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {


    public static void main(String[] args) {

        int eventAmount = 5;
        CountDownLatch latch = new CountDownLatch(eventAmount);

        Runnable events = ()->{

            try {
                for (int i = 1; i<=eventAmount; i++){
                    System.out.println("Event no "+i);
                    latch.countDown();
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException interruptedException){

            }


        };

        Runnable mainAction = ()->{

            try {
                latch.await();

            }
            catch (InterruptedException exception){

            }

            System.out.println("main action completed");
        };

        Thread eventsThread = new Thread(events);

        Thread mainActionThread = new Thread(mainAction);

        eventsThread.start();
        mainActionThread.start();

        try {
            eventsThread.join();
            mainActionThread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("execution completed");









    }

}
