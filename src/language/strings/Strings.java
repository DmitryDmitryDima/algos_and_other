package language.strings;

import java.util.Arrays;
import java.util.List;

public class Strings {

    public static void main(String[] args) {

        // получаем char array с заданным диапазоном
        String hello = "hello";
        char[] chunk = new char[3];
        hello.getChars(0,3, chunk, 0 );
        System.out.println(Arrays.toString(chunk));

        // сравнение частей в строках - (более специализированные формы - startsWith и endsWith)
        String str1 = "helxo";
        String str2 = "hello";

        boolean result = str1.regionMatches(0,str2,0, 3);
        System.out.println(result); // true -> hel equals hel


        // демонстрация сортировки строк
        List<String> example = List.of("xxx", "bbb", "aaa");
        List<String> sorted = example.stream().sorted().toList();

        System.out.println(sorted); // aaa, bbb, xxx - сортировка происходит в алфавитном порядке (Comparable интерфейс)

        // index of - первое появление символа или строки
        // lastIndexOf - последнее
        String abcd = "abcd";

        System.out.println(abcd.indexOf("d")); //3
        System.out.println(abcd.indexOf("bc")); // 1

        // пример с поиском в диапазоне
        System.out.println(abcd.indexOf("d", 0,2)); // -1

        // метод join
        String joined = String.join(".", "com", "example", "methods");
        System.out.println(joined); // com.example.methods

        // метод lines - ориентируется на \n \r
        String phrase = """
                hello
                my
                dear friend
                """;

        phrase.lines().forEach(str->{
            System.out.println("consider "+str); // итерация по трем элементам - hello, my, dear friend
        });



















    }
}
