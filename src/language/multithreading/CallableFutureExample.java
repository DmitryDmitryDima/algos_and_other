package language.multithreading;

import java.util.concurrent.*;

public class CallableFutureExample {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(new Solver());

        Future<Integer> future2 = executorService.submit(new Solver2());

        try {

            // future.get() блокирует поток

            System.out.println(future1.get());
            System.out.println(future2.get());


            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }



}

class Solver implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        Thread.sleep(1000);

        return 200;
    }
}

class Solver2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {

        Thread.sleep(5000);

        return 300;
    }
}

