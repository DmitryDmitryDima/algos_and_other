package language.io;

import java.util.Scanner;

public class Scanners {

    public static void main(String[] args) {
        averageNumber();
    }


    // Scanner автоматически определяет, какой элемент идет следующим
    // данная программа дает среднее значение того, что было введено пользователем
    // input может быть разным
    public static void averageNumber(){

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;

        while (scanner.hasNext()){
            if (scanner.hasNextDouble()){
                count++;
                sum+=scanner.nextDouble();
                System.out.println("Average is "+(sum/count));

            }
            else {
                String next = scanner.next();
                if (next.equals("end")){
                    scanner.close();
                    break;
                }

            }
        }
    }
}
