//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Arrays;
import java.util.Random;

class Outer {

    public void testInner(){
        Inner inner = new Inner();
        inner.testInnerMethod(); // можно вызывать приватный метод внутреннего класса
    }

    // для вызова из внутреннего класса
    private void testOuterMethod(){}

    static class Inner {

        public void testOuter(){
            Outer outer = new Outer();
            outer.testInner(); // можно вызывать приватный метод внешнего класса
        }

        // для вызова из внешнего класса
        private void testInnerMethod(){}
    }
}






public class  Main {




    static void varArg(String ...args){

        // args is just array

        Arrays.stream(args).forEach(System.out::println);
    }








    public static void main(String[] args) {



        try {

        }

        catch (NullPointerException n){

        }


    }


    private static void printArray(int e, int[] array){
        if (e==0) return;
        else printArray(e-1, array);
        // возвращение в это место - выполнение этой строки - и так далее
        System.out.println(array[e-1]);
    }
}


class Example {

    public Example (){

    }

    public void test(double x){
        // если послать int, аргумент автоматически превратится в double
    }

    public void test(int x, int y){

    }




}



