package language.generics;

public class SimpleGeneric {
    public static void main(String[] args) {

        Example.method(new Double[]{3.0,2.0});

        Example.method(new Integer[]{1,2,3,4});

    }

}


// простой дженерик класс
class Example <T>{

    private T parameterField;

    public Example(T parameterField){
        this.parameterField = parameterField;
    }

    public T getParameterField(){
        return parameterField;
    }

    public void showType(){
        System.out.println(parameterField.getClass().getName());
    }


    // пример метода, ограниченного суперклассом

    public static <X extends Number> void method (X[] type){
        double sum = 0.0;
        for (Number n:type){
            sum+=n.doubleValue();
        }

        System.out.println(sum);
    }
}



