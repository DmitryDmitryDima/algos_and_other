package language.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicMapInterfaces {

    public static void main(String[] args) {
        MapInterfaceDemo();
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
