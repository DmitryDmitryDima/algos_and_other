package language.multithreading;

public class VirtualThreads {


    public static void main(String[] args) throws InterruptedException {


        Thread virtual = Thread.ofVirtual().start(()->{

            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        virtual.join();





    }
}
