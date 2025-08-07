package language.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildCard {


    public static void main(String[] args) {
        count(List.of(1,2,3,4));









        /*
        Инвариантность - Integer is a subtype of Number => true
        List<Integer> is a subtype of List<Number> => false (ведь в списке Number могут быть не только Integer)

         */
        List<Number> invariant1 = new ArrayList<>();
        //invariant1 = new ArrayList<Integer>(); // error

        /*
        далее - парадигма PECS – producer extends, consumer super
         */

        /*
        Ковариантность - Integer is a subtype of Number = true
        List<Integer> is a subtype of List<? extends Number> = true
        исходя из этого, мы можем читать тип Number
         */
        List<Integer> x = new ArrayList<>();
        x.add(5);
        List<? extends  Number> y  = x; // не ясно, какой именно подтип, но точно Number

        Number number = y.getFirst(); // ковариантность - возможно чтение

        /*
        Контравариантность -Integer is a subtype of Number = true
        List<? super Integer> is a subtype of Number = true
        исходя из этого, мы можем писать в List<? super Integer> тип Integer
         */

        List<Integer> d = new ArrayList<>();
        d.add(5);
        List<? super  Integer> c = d;
        Object unknown = c.getFirst(); // можно читать лишь Object

        c.add(5); // контравариантность - возможна запись (не ясно, какой именно старший тип, но он точно Integer)








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
