package yandex;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmountOfWords {



    static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new
                FileReader(
                        "C:\\Users\\admin\\Desktop\\ecosystem\\disk\\projects_service\\system_storage\\build_instructions\\maven_classic.yaml"));



        String content = reader.readAllAsString();

        content = """
                She sells sea shells on the sea shore;
                The shells that she sells are sea shells I'm sure.
                So if she sells sea shells on the sea shore,
                I'm sure that the shells are sea shore shells.
                """;



        String another = "AA aa Aa aA\n";

        Set<String> words = new HashSet<>();
        List<String> allWords = new ArrayList<>();
        StringBuilder word = new StringBuilder();



       another.lines().forEach(line->{
            for (int x = 0; x<line.length(); x++){

                char character = line.charAt(x);

                if (Character.isLetter(character)){
                    System.out.println(character+" letter");
                    word.append(character);

                    if (x==line.length()-1){
                        words.add(word.toString());
                        allWords.add(word.toString());
                        word.setLength(0);
                    }
                }

                else if (Character.isSpaceChar(character)){
                    System.out.println(character+" is space char");
                    if (!word.isEmpty()){
                        words.add(word.toString());
                        allWords.add(word.toString());



                        word.setLength(0);


                    }
                }

                else {

                    Character next = x==line.length()-1?null:line.charAt(x+1);

                    // конец строки или дальше пробел - обычный знак препинания
                    if (next==null || Character.isSpaceChar(next)){
                        allWords.add(word.toString());
                        words.add(word.toString());

                        word.setLength(0);

                        allWords.add(Character.toString(character));
                        words.add(Character.toString(character));

                    }
                    // если дальше - буква
                    else {
                        word.append(character);

                        allWords.add(word.toString());
                        words.add(word.toString());



                        word.setLength(0);

                    }


                }


            }







        });



        System.out.println(words);
        System.out.println(allWords);
        System.out.println(words.size());


        allWords.forEach(el->{
            System.out.println("element:"+el);
        });


    }
}
