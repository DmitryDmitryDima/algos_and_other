package language.collections;

import language.io.Console;


import java.util.*;

public class BasicMapInterfaces {



    public static void main(String[] args) {

        enum Test {ONE, TWO};

        EnumMap<Test, String> map = new EnumMap<>(Test.class);

        map.put(Test.ONE, "Hello");

        System.out.println(map);



        int[] x = {1,2,3};
        int[] x2 = {1,2,5};

        System.out.println(Arrays.mismatch(x, x2)); // 2


    }

    public static void SortedMapDemo(){
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(2,"Dima");
        sortedMap.put(3,"Matt");
        sortedMap.put(1, "John");
        sortedMap.put(4,"Kate");

        // 1,2,3,4

        // последний и первый ключи
        Integer firstKey = sortedMap.firstKey(); // 1
        Integer lastKey = sortedMap.lastKey(); //4

        // sub map, где ключ < 3
        SortedMap<Integer, String> headMap = sortedMap.headMap(3); //1 2
        // sub map, где ключ >= 2
        SortedMap<Integer, String> tailMap = sortedMap.tailMap(2); // 2,3,4

        // sub map c обеими границами
        SortedMap<Integer, String> subMap = sortedMap.subMap(2,4); // 2,3

    }


    public static void SequencedMapInterfaceDemo(){
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();
        // по аналогии с очередью, мы можем вставлять либо в начало, либо в конец, и порядок сохранится
        sequencedMap.putLast(2,"Dima");
        sequencedMap.putFirst(1, "Mate");
        sequencedMap.putLast(3, "John");
        // 1 2 3 order

        // контент
        for (Map.Entry<Integer, String> entry:sequencedMap.sequencedEntrySet()){
            System.out.println(entry);
        }
        // контент
        sequencedMap.forEach((k,v)->{});

        // удаляем пару в начале
        Map.Entry<Integer, String> removedFromStart = sequencedMap.pollFirstEntry(); // 1 - Mate

        // удаляем пару в конце
        Map.Entry<Integer, String> removedFromEnd = sequencedMap.pollLastEntry(); // 3 - John

    }



    public static void MapInterfaceDemo(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Dmitry");
        String oldValue = map.put(1, "Lexo"); // Dmitry - если элемент есть, возвращается предыдущее значение, если нет - null

        /*
        v - старое значение (Lexo), newValue - новое (Lexo updated)
        Возвращает null, если значения не было
         */
        String newValue = map.compute(1, (k, v)->{

            return v+" updated";
        });

        // получаем значение по ключу (lexo updated).
        // если бы его не было, сработала бы функция, и значения было бы default value
        String value = map.computeIfAbsent(1, (k)->{return "default value";});

        /*
        если значение по ключу присутствует, происходит его обновление из функции
        Если функция возвращает null, пара удаляется и возвращается null
         */
        String computeIfPresentResult = map.computeIfPresent(1, (k, v)->{
            return "Kate";
        });

        // удобный способ создать пару с помощью статического метода
        Map.Entry<Integer, String> entryExample = Map.entry(2,"hello");

        // итерация по содержимому мапы с помощью entrySet
        for (Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        // альтернативный способ пройти по содержимому словаря
        map.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });

        String result  = map.getOrDefault(2, "Default"); // Default - если ключа нет, возвращаем дефолтное значение

        // путешествие по ключам
        Set<Integer> keys = map.keySet();

        // еще один update method
        // если ключа нет в мапе, то заносится новая пара. Если есть - происходит обновление существующей пары в функции.
        // если функция возвращает null, то пара стирается
        map.merge(1,"Hello", (k,v)->v+" new part"); // update старой пары

        map.merge(2, "Again", (k,v)->v+" new part"); // новая пара


        // удобные способы создать неизменяемый словарь
        Map.of(1,"Hello", 2, "Again");
        Map.ofEntries(Map.entry(1,"hello"), Map.entry(2, "Again"));


        map.putIfAbsent(1, "lol"); // вставка значения только в случае отсутствия пары (без перезаписывания)

        String removed = map.remove(1); // Hello new part - удаление по ключу

        String replaced = map.replace(2, "AGAIN"); // Again - замена на новое значение

        map.clear(); // удаляем все существующие пары

    }
}
