package language;

public class Exceptions {


    public static void main(String[] args)  {


        try {

            // в этом блоке может быть две ошибки
            int[] x = {3,5,0};

            int y = 5/x[2];

            x[100] = 100;
        }
        catch (final ArithmeticException|ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }


}


