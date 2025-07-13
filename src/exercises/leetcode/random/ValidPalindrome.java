package exercises.leetcode.random;

public class ValidPalindrome {

    public static void main(String[] args) {


        String ex = "abbbaa";
        System.out.println(new ValidPalindrome().isPal(ex));

    }




    public boolean isPal(String s){

        int left = 0;
        int right = s.length()-1;

        while (left<right){

            // skip all offtop symbols
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            // again
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }


       return true;
    }



    //
    public boolean isPalindrome(String s) {

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();


        for (int x = 0, y = s.length()-1; x<s.length() && y>=0; x++, y--){

            char left = s.charAt(x);
            char right = s.charAt(y);

            if (Character.isAlphabetic(left)||Character.isDigit(left)){
                first.append(Character.toLowerCase(left));
            }

            if (Character.isAlphabetic(right)||Character.isDigit(right)){
                second.append(Character.toLowerCase(right));
            }





        }

        System.out.println(first +" first");
        System.out.println(second);




        return first.compareTo(second) == 0;
    }









}




