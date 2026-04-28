package exercises2.algo_patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;

public class Test {


    static int height = 0;



    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("7 1 9 10 0"));

        TreeMember head = null;


        String[] numbers = reader.readLine().split(" ");

        for (int i = 0; i<numbers.length; i++){

            int value = Integer.parseInt(numbers[i]);

            if (i == 0){
                head = new TreeMember(value);
                height = 1;
            }
            else if (i == numbers.length-1){
                break;
            }

            else {
                addValue(value, head);
            }
        }







    }

    static void addValue(int value, TreeMember member){



        TreeMember current = member;

        int localHeight = 1;

        while (true){

            System.out.println("current "+current.value+" inserting " + value);


            if (value>current.value){
                if (current.right == null){
                    current.right = new TreeMember(value);
                    localHeight++;

                    break;
                }
                else {
                    current = current.right;

                }
            }

            else {
                if (current.left == null){
                    current.left = new TreeMember(value);
                    localHeight++;

                    break;
                }
                else {
                    current = current.left;

                }
            }

            localHeight++;
        }

        if (localHeight>height) {
            height = localHeight;
        }

    }



    static class TreeMember{
        int value;
        TreeMember left;
        TreeMember right;

        TreeMember(int value){
            this.value = value;
        }
    }
}
