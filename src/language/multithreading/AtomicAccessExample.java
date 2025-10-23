package language.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAccessExample {

    private final static AtomicInteger resource = new AtomicInteger(1);

    public static void main(String[] args) {


        Runnable action = ()->{
            for (int i =0; i<100; i++){
                int value = resource.getAndIncrement(); // чтение и инкремент - одна атомарная синхронизированная операция

                System.out.println(value);
            }

        };

        new Thread(action).start();
        new Thread(action).start();

    }
}
