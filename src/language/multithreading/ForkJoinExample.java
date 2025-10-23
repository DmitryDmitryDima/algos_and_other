package language.multithreading;

import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Stream;

public class ForkJoinExample {

    public static void main(String[] args) {


        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        double[] array = new double[10000000];

        for (int i = 0; i<array.length; i++){
            array[i] = 2;
        }

        Instant time = Instant.now();

        ArrayWorker worker= new ArrayWorker(array, 0, array.length);

        forkJoinPool.invoke(worker);

        System.out.println(Instant.now().getNano()-time.getNano());




    }




}


class ArrayWorker extends RecursiveAction{

    private int thresholdValue = 100000; // минимальный размер куска, с которого вычисление будет sequential. Пока мы его не достигнем,
    // мы будем создавать новые потоки

    private double[] array;

    private int start;
    private int end;


    public ArrayWorker(double[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        int size = end-start;

        // sequentional
        if (size<=thresholdValue){
            for (int i = start; i<end; i++){
                // возводим в квадрат
                array[i] = Math.pow(array[i], 2);
            }
        }

        // размер больше порога - делим еще на две задачи
        else {
            int middle = (start+end)/2;

            ArrayWorker left = new ArrayWorker(array, start, middle);
            ArrayWorker right = new ArrayWorker(array, middle, end);

            invokeAll(left, right);
        }
    }
}
