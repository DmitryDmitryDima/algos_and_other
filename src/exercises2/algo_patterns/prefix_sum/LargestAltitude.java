package exercises2.algo_patterns.prefix_sum;

/*
Некий велосипедист стартует с точки с высотой 0. На входе дается массив, содержащий данные
- насколько высота изменилась на той или иной точке.
По сути необходимо создать рассчитать prefix sum массив для gain,
- при этом начав с нуля - распространенная техника в подобного рода задачах.

 */
public class LargestAltitude {

    static void main() {

    }

    public int largestAltitude(int[] gain) {


        int highest = 0;

        int currentPrefix = 0;

        for (int i:gain){

            currentPrefix = currentPrefix+i;

            if (highest<currentPrefix){
                highest = currentPrefix;
            }
        }

        return highest;
    }


}
