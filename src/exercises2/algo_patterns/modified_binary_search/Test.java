package exercises2.algo_patterns.modified_binary_search;

public class Test {



    static void main(){

        int[] input = {1,0,0,0,0};


        System.out.println(findSize(input));

    }



    private static int findSize(int[] row){


        int left = 0;

        int right = row.length-1;

        int lastOccurence = -1;


        while (left<=right){
            int middle = (left+right)/2;

            if (row[middle] == 1){

                left = middle+1;

                lastOccurence = middle;
            }

            else{
                right = middle-1;
            }
        }



        return lastOccurence+1;
    }



}
