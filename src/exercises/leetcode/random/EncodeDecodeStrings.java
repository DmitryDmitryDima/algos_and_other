package exercises.leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        String[] array = {"Helloo", "Again"};
        EncodeDecodeStrings e = new EncodeDecodeStrings();
        String s = e.encode(array);
        System.out.println(Arrays.toString(e.decode(s)));


    }

    public String[] decode(String info){

        int length = Integer.parseInt(info.substring(0,3));


        String content = info.substring(3, length+3);

        String[] lengths = info.substring(3+length).split("\\.");

        List<String> output = new ArrayList<>();

        int gone = 0;
        for (int i = 0; i < lengths.length ; i++) {
            int l = Integer.parseInt(lengths[i]);

            output.add(content.substring(gone,gone+l));
            gone+=l;


        }




        // so called overloaded variant

        return output.toArray(new String[output.size()]);
    }

    // условие - длина строки не больше 200
    public String encode(String[] array){
        // сюда записываем координаты разрыва
        StringBuilder lengths = new StringBuilder();
        StringBuilder string = new StringBuilder();
        // длина всей строки - нужно, чтобы при декодировании понимать, где начнется инфа по остановкам
        int stringLength = 0;
        for (int i = 0; i < array.length; i++) {

            String s = array[i];
            string.append(s);

            stringLength+=s.length();

            if (i!=array.length-1){
                lengths.append(s.length()).append(".");
            }
            else {
                lengths.append(s.length());
            }


        }

        StringBuilder encodedLength = new StringBuilder();
        if (stringLength/100>=1){
            encodedLength.append(stringLength);
        }
        else if (stringLength/10>=1){
            encodedLength.append("0").append(stringLength);
        }
        else {
            encodedLength.append("00").append(stringLength);
        }





        return encodedLength.append(string).append(lengths).toString();
    }
}
