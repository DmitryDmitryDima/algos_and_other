package yandex;

import java.io.*;
import java.util.*;


class Entry {


    private int freq;
    private String value;

    Entry(String value){

        this.value = value;
    };

    void updateFreq(){
        freq++;
    }

    int getFreq(){
        return this.freq;
    }

    String getValue(){
        return this.value;
    }

    int getSize(){
        return this.value.length();
    }


    @Override
    public String toString() {
        return "Entry{" +
                "freq=" + freq +
                ", value='" + value + '\'' +
                '}';
    }
}

class Completion{


    private Map<Character, List<Entry>> charIndex;
    private Map<String, Entry> directIndex;

    Completion(String[] words){
        charIndex = new HashMap<>();
        directIndex = new HashMap<>();
        prepareStructure(words);
    }

    String complete(String input){
        Character c = input.charAt(0);



        List<Entry> candidates = charIndex.get(c);

        candidates.sort(Comparator.comparing(Entry::getFreq)
                .thenComparing(Entry::getValue));

        System.out.println(candidates);

        Entry candidate = candidates.getFirst();

        candidate.updateFreq();



        return candidate.getValue();


    }

    private void prepareStructure(String[] words){

        for (String word:words){

            Character first = word.charAt(0);


            Entry entry = new Entry(word);
            directIndex.put(word, entry);

            charIndex.compute(first, (k,v)->{

                if (v == null){
                    List<Entry> entries = new ArrayList<>();
                    entries.add(entry);
                    return entries;
                }

                else {
                    v.add(entry);
                    return v;
                }
            });

        }


    }


}


public class Contest{










    public static void main(String ...args) throws IOException{



        BufferedReader reader
                = new BufferedReader(new StringReader("5\n" +
                "y x 3 x y 3\n" +
                "z x y 2 z 3"));

        BufferedWriter writer
                = new BufferedWriter(new OutputStreamWriter(System.out));


        Integer seqLength = Integer.valueOf(reader.readLine());

        String[] first = reader.readLine().split(" ");

        String[] second = reader.readLine().split(" ");

        HashMap<String, String> variables = new HashMap<>();

        String numberEx = "-?\\d+(\\.\\d+)?";

        ArrayList<Integer> missed = new ArrayList<>();

        boolean error = false;

        for (int i =0; i<seqLength; i++){

            String firstValue = first[i];
            String secondValue = second[i];

            System.out.println(firstValue+" "+secondValue);

            boolean firstNumber = firstValue.matches(numberEx);

            boolean secondNumber = secondValue.matches(numberEx);

            if (!firstValue.equals(secondValue)){

                if (!firstNumber && !secondNumber) {
                    String v1 = variables.get(firstValue);
                    String v2 = variables.get(secondValue);

                    if (v1 == null && v2 == null){
                        missed.add(i);
                    }

                    else if (v1 == null){
                        variables.put(firstValue, v2);
                        System.out.println(variables);
                    }
                    else if (v2 == null){
                        variables.put(secondValue, v1);
                        System.out.println(variables);
                    }

                    else {
                        if (!v1.equals(v2)){
                            error = true;
                            break;
                        }
                    }
                }

                else if (firstNumber && secondNumber) {
                    error = true;
                    break;
                }

                else if (firstNumber && !secondNumber){

                    String variableValue = variables.get(secondValue);

                    if (variableValue == null){
                        variables.put(secondValue, firstValue);
                    }

                    else {
                        if (!variableValue.equals(firstValue))
                        {
                            error = true;
                            break;
                        }
                    }

                }

                else {

                    String variableValue = variables.get(firstValue);

                    if (variableValue == null){
                        variables.put(firstValue, secondValue);
                    }

                    else {
                        if (!variableValue.equals(secondValue))
                        {
                            error = true;
                            break;
                        }
                    }

                }




            }

        }

        // проверяем места, где переменные изначально не были известны
        for (int point:missed){

            System.out.println(missed);

            String firstVar = first[point];

            String secondVar = second[point];

            System.out.println(variables);

            String value1 = variables.get(firstVar);
            String value2 = variables.get(secondVar);

            if (!value1.equals(value2)){
                error = true;
            }
        }


        if (error){
            writer.write("NO");
        }
        else {
            writer.write("YES");
        }





        reader.close();
        writer.close();









    }








}