package exercises.leetcode.two_pointers;

public class FindTheIndexOfTheFirstOccurenceInAString {


    public static void main(String[] args) {
        String needle = "leto";
        String haystack = "leetcode";

        System.out.println(new FindTheIndexOfTheFirstOccurenceInAString().strStr(haystack, needle));

    }

    public int strStr(String haystack, String needle) {

        int slow = 0;
        while (slow<=haystack.length()-needle.length()){


            if (haystack.charAt(slow)==needle.charAt(0)) {
                int fast;
                for (fast = 0; fast<needle.length(); fast++){
                    if (needle.charAt(fast)!=haystack.charAt(fast+slow)) {
                        break;
                    }
                }
                // проверяем, был ли полностью выполнен цикл for
                if (fast==needle.length()) return slow;

            }
            slow++;
        }

        return -1;
    }
}
