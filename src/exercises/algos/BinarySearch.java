package exercises.algos;

public class BinarySearch {

    
    public static void main(String[] args) {
        int [] sorted = new int[]{1,2,3,4,5,6,7,8};
        // testing rebase - i did it on local
        for (int x:sorted){
            System.out.println(new BinarySearch().hard(sorted, x, 0, sorted.length-1));
        }

    }


    private int hard(int[] array, int target, int low, int high){
        if (low>high) return -1;
        int mid = (low+high)/2;
        int value = array[mid];
        if (value == target) return mid;
        else if (value>target){
            return hard(array, target, low, mid-1);
        }
        else {
            return hard(array,target,mid+1, high);
        }
    }


    private int simple(int[] sortedArray, int target){


        int start = 0;
        int end = sortedArray.length-1;

        while (start<=end){
            int mid = (start+end)/2;

            int value = sortedArray[mid];

            if (value == target) return mid;

            else if (value<target){
                start = mid+1;
            }

            else {
                end = mid -1;
            }
        }

        return -1;
    }
}
