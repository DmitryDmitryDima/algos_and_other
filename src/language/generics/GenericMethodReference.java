package language.generics;


interface ExampleInterface<T> {

    void call(T ex);
}
public class GenericMethodReference {
    public static void main(String[] args) {

        // classic lambda example
        exampleMethod((obj)->{
            System.out.println(obj.getClass());
        }, new Object());

        // generic method reference example
        exampleMethod(GenericMethodReference::<Integer>methodForReference, 5);
    }



    public static <T> void exampleMethod(ExampleInterface<T> inter, T ex){

        inter.call(ex);
    }


    public static <T> void methodForReference(T ex){
        System.out.println(ex.getClass());
    }





}
