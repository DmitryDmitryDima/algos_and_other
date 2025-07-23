package language.random_things;

// два вида статического импорта
import static java.lang.Math.pow;
import static java.util.Arrays.*;



public class StaticImport {

    public static void main(String[] args) {


        double power = pow(2, 3); // два в третьей степени ==> 8

        System.out.println(deepToString(new int[][]{{1}}));

    }
}
