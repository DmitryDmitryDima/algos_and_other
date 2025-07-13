package language.words;

import java.util.Random;

public class AssertExample {


    public static void main(String[] args) {
        while (true){
            example();
        }
    }



    public static int example(){

        Random random = new Random();
        int result = random.nextInt(-100,100);
        System.out.println(result);
        assert result>0; // если нет, то выбросит AssertionError в специальном режиме запуска
        return result;
    }
}
