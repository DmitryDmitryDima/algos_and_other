package language.streams;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {



        collectingExample();
    }


    private static void reduceExample(){
        List<Integer> list = List.of(1,2,3,4,5);

        // acc - аккумулируемое значение
        // streamvalue - значение потока
        // identity - начальное значение для acc
        int result = list.stream().reduce(100, (acc, streamValue)->streamValue*acc);

        System.out.println(result); // 100* 1 * 2 * 3 * 4 * 5
    }

    private static void collectingExample(){
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        // первый аргумент - в каком виде будет представлен результат
        // второй аргумент - каким образом данные записываются в коллекцию-результат
        // третий аргумент - только для parallel stream - как объединяется результат из разных потоков
        List<Integer> newList =linkedList.stream().map(el->el+1).collect(LinkedList::new,
                LinkedList::add,
                LinkedList::addAll
                );

        System.out.println(newList);

        // альтернатива
        List<Integer> newList2 = linkedList.stream().collect(Collectors.toCollection(LinkedList::new));
    }
}
