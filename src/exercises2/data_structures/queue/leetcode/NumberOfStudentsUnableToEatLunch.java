package exercises2.data_structures.queue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// задача на симуляцию - очередь студентов + стопка сэндвичей
// студент может скушать лишь определенный сендвич - если сэндвич не его - встает в конец очереди
public class NumberOfStudentsUnableToEatLunch {

    static void main() {

        int[] students = {1,1,1,0,0,1};

        int[] sands = {1,0,0,0,1,1};

        System.out.println(countStudents(students, sands));
    }



    public static int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> studs = new ArrayDeque<>();

        Queue<Integer> sands = new ArrayDeque<>();


        for (int i: students){
            studs.offer(i);
        }

        for (int i:sandwiches){
            sands.offer(i);
        }


        int cycle = 0;

        while (cycle<studs.size()
                &&
                !sands.isEmpty() && !studs.isEmpty()){

            int sand = sands.peek();

            int stud = studs.peek();

            System.out.println("I am a stud "+stud+" and I see sand "+sand);

            if (sand == stud){
                cycle = 0;
                sands.poll();
                studs.poll();

                System.out.println("I eat it");
                System.out.println("studs = "+studs+" sands = "+sands);
            }

            else {

                cycle++;



                int polled = studs.poll();

                studs.offer(polled);

                System.out.println("I don't eat it. Go to the end with cycle = "+cycle);
                System.out.println("studs  = "+studs+" sands = "+sands);

            }

        }

        return studs.size();
    }
}
