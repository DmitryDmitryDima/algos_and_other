package language.multithreading;

public class DeadLock {

    static void deadlockClassic(){

        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(()->{
            synchronized (lock1){
                synchronized (lock2){

                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                synchronized (lock1){

                }
            }


        }).start();
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Thread t = new Thread(()->{
            a.methodA(b);
        });
        Thread t1 = new Thread(()->{
            b.methodB(a);
        });
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("end will never reached");

    }
}


class A {
    synchronized void methodA(B b){
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        b.last();
    }

    synchronized void last(){

    }
}

class B {

    synchronized void methodB(A a){
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        // Поток с B ждет, пока освободится потока A, однако он то же ждет, но уже поток с B. оба потока в вечном ожидании
        a.last();
    }

    synchronized void last(){

    }
}
