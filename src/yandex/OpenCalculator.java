package yandex;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenCalculator {

    static void main(){

        String[] input = {"5","7","3"};




        Set<String> set = new HashSet<>(List.of(input));

        String hello = "123";
        int count = 0;

        for (String digit:hello.split("")){
            if (set.add(digit)){
                count++;
            }
        }
        System.out.println(count);



    }
}
