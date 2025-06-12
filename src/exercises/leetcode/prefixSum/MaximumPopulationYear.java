package exercises.leetcode.prefixSum;

public class MaximumPopulationYear {
    public static void main(String[] args) {
        int[][] sample = {{1950,1961},{1960,1971},{1970,1981} };

        System.out.println(new MaximumPopulationYear().maximumPopulationPrefixSum(sample));
    }


    public int maximumPopulationPrefixSum(int[][] logs){

        // создаем массив с годами (по условию задачи диапазон - 1950-2050)
        int[] deltas = new int[101];
        int offset = 1950;

        // фиксируем изменение популяции в каждый из годов
        for (int[] log:logs){

            int birthIndex = log[0] - offset;
            int deathIndex = log[1] - offset;

            ++deltas[birthIndex];
            --deltas[deathIndex];

        }

        int currentPop = 0;
        int maxPop = 0;
        int maxYear = 0;

        // суммируем дельты, вылавливая максимальное число (популяцию) - по сути алгоритм prefix sum
        for (int i = 0; i<deltas.length; i++){

            int delta = deltas[i];

            currentPop+=delta;
            if (currentPop>maxPop){
                maxPop = currentPop;
                maxYear = i+offset;
            }

        }


        return maxYear;
    }

    public int maximumPopulation(int[][] logs) {


        int maxPopulationYear = logs[0][0];
        int maxPopulation = 0;

        for (int[] log : logs) {

            int year = log[0];
            int peopleCount = 0;

            for (int[] person : logs) {
                if (person[0] <= year && person[1]>year) {
                    peopleCount++;
                }
            }

            System.out.println(peopleCount+" for year "+year);

            if (peopleCount > maxPopulation) {
                maxPopulation = peopleCount;

                maxPopulationYear = year;
            }
            else if (peopleCount == maxPopulation && maxPopulationYear>year){
                maxPopulationYear = year;
            }


        }



        return maxPopulationYear;
    }
}
