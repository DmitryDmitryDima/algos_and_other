package language.words;

public class Volatile {

    volatile int x = 0;

    volatile boolean flag = true;

    // некорректно!
    public void increase(){
        x++; // Опасно! - в данном случае выполняется три операции сразу!
    }

    // корректно
    public synchronized void safeIncrease(){
        x++; //безопасно
    }

    // корректно
    public void changeFlag(){
        flag = true; // корректно - атомарная операция
    }

}
