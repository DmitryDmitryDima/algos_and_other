package exercises.algos;

public class BigO {

    public static void main(String[] args) {
        linearLog(8);
    }

    // общее время прямо зависит количества элементов в массиве
    static void linear(int[] array){

        for (int i : array) {
            System.out.println(i * 100);
        }

    }

    // алгоритм всегда выполняется с одинаковым временем
    static void bigO1(){
        var result = 1000*1000;

    }

    static void On2(int n){

        // define square
        for (int i =0; i<n; i++){ // n
            for (int j = 0; j<n; j++){ //n
                System.out.println(i+" "+j);
            }
        }
    }

    // n*n*n
    static void On3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println(i+" "+j+" "+k);
                }
            }
        }
    }

    // O log n - двоичный логарифм
    static void recursive(double n){
        System.out.println(n);
        if (n == 0) {
            System.out.println("Done");
        }

        else {
            recursive(Math.floor(n/2));
        }
    }

    // O nlogn
    static void linearLog(int n){
        for (int i = 0; i <= n; i++) {
            // O log n операция внутри O(n)
            int divided = i;
            while (divided>=1){
                divided = divided/2;
            }
        }
    }

    static void linearLogInverted(int n){
        int total = n;
        while (n>=1){
            n = n/2;
            for (int i = 0; i < total; i++) {
                // some action
            }
        }
    }
}
