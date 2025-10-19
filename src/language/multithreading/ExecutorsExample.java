package language.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

    public static void main(String[] args) {





        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){

            }
            System.out.println("end of thread 1");
        });

        executorService.submit(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e){

            }
            System.out.println("end of thread 2");
        });

        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS); // грамотно ждать окончания операций некоторое время, а не грубо убивать
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }




}
