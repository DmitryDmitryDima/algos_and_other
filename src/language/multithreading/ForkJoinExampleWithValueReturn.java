package language.multithreading;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExampleWithValueReturn {

    public static void main(String[] args) {

        ForkJoinPool pool = ForkJoinPool.commonPool();

        int[] array = new int[1000000];
        Arrays.fill(array, 1);

        int sum = pool.invoke(new ArraySumWorker(array, 0, array.length));
        System.out.println(sum); // 1000000
    }
}

class ArraySumWorker extends RecursiveTask<Integer>{

    private final int threshold = 100;
    private int start ;
    private int end;
    private int[] array;

    public ArraySumWorker(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        int size = end - start;
        if (size<threshold){
            for (int i = start; i<end; i++){
                sum+=array[i];
            }
        }
        else {
            int middle = (start+end)/2;

            ArraySumWorker left = new ArraySumWorker(array, start, middle);
            ArraySumWorker right = new ArraySumWorker(array, middle, end);

            ForkJoinTask<Integer> leftWorker = left.fork();
            ForkJoinTask<Integer> rightWorker = right.fork();

            // ждем результата и возвращаем его
            sum = leftWorker.join()+rightWorker.join();

        }
        return sum;
    }
}


