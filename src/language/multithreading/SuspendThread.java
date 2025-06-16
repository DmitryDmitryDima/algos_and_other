package language.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class SuspendThread {

    public static void main(String[] args) throws InterruptedException {

        SuspendAndResumeThread s = new SuspendAndResumeThread();
        s.start();

        Thread.sleep(5000);
        System.out.println("pause start");
        s.pause();
        Thread.sleep(10000);
        s.resume();
        System.out.println("pause end");

    }
}



class SuspendAndResumeThread implements Runnable{

    private boolean suspended = false;

    @Override
    public void run() {



        for (int i = 0; i<15; i++){
            int lag = ThreadLocalRandom.current().nextInt(1000,1200);
            try {
                Thread.sleep(lag);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(i);

            synchronized (this){
                while (suspended){
                    try {
                        // ждем, когда флаг изменится. Ожидая, поток не тратит ресурсы
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


    }

    public synchronized void pause(){
        suspended = true;
    }

    // notify должен вызываться в synchronized!
    public synchronized void resume(){
        suspended = false;
        notify();
    }

    public void start(){
        Thread t = new Thread(this);
        t.start();
    }
}
