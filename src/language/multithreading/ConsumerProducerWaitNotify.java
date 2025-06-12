package language.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class ConsumerProducerWaitNotify {


    public static void main(String[] args) {

        final SynchroQueue queue = new SynchroQueue();

        Thread producer = new Thread(()->{
            for (int i =0; i<5; i++){
                int lag = ThreadLocalRandom.current().nextInt(3000,5000);
                try {
                    Thread.sleep(lag);
                    queue.put(i);
                }
                catch (InterruptedException interruptedException){
                    interruptedException.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(()->{
            int result = -1;
            long time = System.currentTimeMillis();
            while (result<4){
                result = queue.getData();
                long now = System.currentTimeMillis();
                long spent = now - time;
                time = now;
                System.out.println("I got result "+result+" after "+spent);
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Execution end");


    }
}

class SynchroQueue{

    // флаг, сообщающий, готовы ли данные для извлечения
    // доступ к нему защищен synchronized, поэтому не требует volatile
    private boolean dataReady;
    private int data;

    // производитель использует этот метод для записи данных
    public synchronized void put (int data){

        // пока данные готовы - ждем - в это время поток потребителя читает данные
        while (dataReady) {
            try {
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        // после прочтения пишем данные, изменяем флаг на true, уведомляем потребителя
        // (если их много, используем notifyAll())
        this.data = data;
        dataReady = true;
        notify();

    }

    // потребитель использует этот метод для чтения данных
    public synchronized int getData(){
        // если данные не готовы - их нельзя читать - ждем
        while (!dataReady){
            try {
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        // читаем данные,
        // не забываем изменить флаг и проинформировать продюсера о том, что данные прочитаны
        dataReady = false;
        notify();
        return data;

    }
}
