package exercises.leetcode.prefixSum;

public class FindAHighestAltitude {

    public static void main(String[] args) {
        int[] sample = {-5,1,5,0,-7};
        System.out.println(new FindAHighestAltitude().largestAltitude(sample));
    }

    public int largestAltitude(int[] gain) {

        int altitude = 0;
        int highest = 0;
        for (int i:gain){
            altitude+=i;
            highest = Math.max(highest, altitude);
        }

        return highest;
    }
}
