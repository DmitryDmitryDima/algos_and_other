package language.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildCard {


    public static void main(String[] args) {
        count(List.of(1,2,3,4));





        List<Integer> x = new ArrayList<>();
        x.add(5);
        List<? extends  Number> y  = x;

        Number number = y.getFirst(); // ковариантность - возможно чтение

        List<Integer> d = new ArrayList<>();
        d.add(5);
        List<? super  Integer> c = d;

        c.add(5); // контравариантность - возможна запись



    }

    // что-то, что точно является Number, но не понять, какая именно ступень ниже по иеррахии
    // Может быть List<Integer>, List<Double> и т д
    // можем читать, но не записывать
    static void count(List<? extends Number> sample){

        double count = 0;
        for (Number n:sample){
            count+=n.doubleValue();
        }

        System.out.println(count);
    }

    // что-то, что точно является Integer, но неизвестно, какая именно ступень выше по иерархии
    // можем передать List<Integer>, List<Number>
    // Мы можем записывать, но не читать
    static void low(List<? super Integer> sample){

        sample.add(5);
    }
}
