package exercises.algos;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,4,4,4,3,2};
        new MergeSort().mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }


    public void mergeSort(int[] array, int start, int end){
        if (start>=end) return;

        int mid = (start+end)/2;

        mergeSort(array, start,mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid, end);


    }
    private void merge(int[] array, int start, int mid, int end){

        int[] firstChunk = new int[mid-start+1];
        int[] secondChunk = new int[end -mid];



        int x = 0;
        for (int i = start; i<=mid; i++){
            firstChunk[x] = array[i];
            x++;
        }

        x=0;

        for (int i = mid+1; i <=end; i++) {
            secondChunk[x] = array[i];
            x++;
        }

        int globalPointer = start;
        int firstChunkPointer = 0;
        int secondChunkPointer = 0;
        while (globalPointer<=end){

            if (firstChunkPointer==firstChunk.length){
                array[globalPointer] = secondChunk[secondChunkPointer];
                secondChunkPointer++;
            }
            else if (secondChunkPointer == secondChunk.length){
                array[globalPointer] = firstChunk[firstChunkPointer];
                firstChunkPointer++;
            }

            else {
                int first = firstChunk[firstChunkPointer];
                int second = secondChunk[secondChunkPointer];

                if (first<=second){
                    array[globalPointer] = firstChunk[firstChunkPointer];
                    firstChunkPointer++;
                }
                else {
                    array[globalPointer] = secondChunk[secondChunkPointer];
                    secondChunkPointer++;
                }
            }

            globalPointer++;

        }




    }
}
