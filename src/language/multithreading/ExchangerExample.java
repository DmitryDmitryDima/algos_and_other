package language.multithreading;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ExchangerExample {


    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();

        Runnable generator = () -> {

            char ch = 'A';

            String str = "";

            for (int i = 0; i<3; i++){

                try {

                    for (int x = 0; x<5; x++){
                        str+=ch++;
                    }

                    // посылаем в другой поток сгенерированную строку. получаем пустую
                    str = exchanger.exchange(str);

                    System.out.println("empty string "+str+" received inside generator thread");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000,10000));


                }
                catch (Exception e){

                }
            }

        };

        Runnable receiver = ()->{

            try {
                for (int i = 0; i<3; i++){
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000,10000));
                    // посылаем пустую строку, получаем полную

                    String str = exchanger.exchange("");

                    System.out.println("string "+str+" received inside receiver thread");

                }
            }
            catch (Exception e){

            }
        };

        try (ExecutorService executorService = Executors.newFixedThreadPool(2)){
            executorService.submit(generator);
            executorService.submit(receiver);
            executorService.shutdown();
        }

    }


}
