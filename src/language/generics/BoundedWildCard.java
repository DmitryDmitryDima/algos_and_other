package language.generics;

import java.util.List;

public class BoundedWildCard {


    public static void main(String[] args) {
        count(List.of(1,2,3,4));
    }

    // указана верхняя граница
    static void count(List<? extends Number> sample){

        double count = 0;
        for (Number n:sample){
            count+=n.doubleValue();
        }

        System.out.println(count);
    }


    static void low(List<? super Integer> sample){

    }
}
