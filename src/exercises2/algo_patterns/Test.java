package exercises2.algo_patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;

public class Test {






    static void main() throws IOException {





        int size = 20;

        int limit = 10;



        int current = 1;

        while (current<=size){

            System.out.println(current+" "+(current-1));


            if (current%limit==0){
                System.out.println("chunk division on "+current);
                System.out.println("index equals "+(current-1));
            }
            current++;
        }
    }

}
