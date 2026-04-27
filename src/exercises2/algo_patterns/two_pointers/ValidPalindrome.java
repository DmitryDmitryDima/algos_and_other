package exercises2.algo_patterns.two_pointers;

/*
двигаемся с двух сторон, пропуская невалидные символы, сравниваем, чтобы в двух указателях буквы/цифры совпадали

Чтобы не делать двойную работу, вводим условие while left<right. Метод toLowerCase не выкидывает ошибки!
 */
public class ValidPalindrome {

    static void main(){


        String s = "0P0";

        char x = '?';

        System.out.println(Character.toLowerCase(x)); // я думал тут ошибка

        System.out.println(new ValidPalindrome().isPalindrome(s));
    }




    public boolean isPalindrome(String s) {



        int left = 0;

        int right = s.length()-1;

        while (left<right){

            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){

                left++;
            }

            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }


            if (Character.toLowerCase(s.charAt(left))
                    !=
                    Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }



        return true;
    }
}
