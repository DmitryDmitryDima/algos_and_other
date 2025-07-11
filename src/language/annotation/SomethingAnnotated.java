package language.annotation;


import java.lang.annotation.Annotation;
import java.util.Arrays;

@MyAnnotation(name = "Dima", value = 5)
public class SomethingAnnotated {


    public static void main(String[] args) {

        // first way
        Annotation[] annotations = SomethingAnnotated.class.getAnnotations();

        for (Annotation a:annotations){
            System.out.println(a.toString());
        }

        // second way

        SomethingAnnotated example = new SomethingAnnotated();
        Class<?> c = example.getClass();

        Arrays.stream(c.getAnnotations()).forEach(System.out::println);

    }

}
