package language.io;

import java.io.*;
import java.net.URI;

public class Characters {












    public static void main(String[] args) {

        String WAY = "C:/Users/User/Desktop/filebase/dima/projects/demo/BinarySearch.java";
        File file = new File(WAY);




        // сырой байтовый поток (нет кодировки при попытке работать с символами)
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            int x;
            while ((x=fileInputStream.read())!=-1){
                System.out.println(x);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // пауза
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){

        }


        // file reader читает буква за буквой
        try (FileReader r = new FileReader(file)){
            int x;

            while ((x = r.read())!=-1) {
                System.out.println((char) x);
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

        // пауза
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){

        }

        // подключаем буфер для порционного чтения файла. повышая эффективность


        try (FileReader r = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(r);
        ){

            String s;
            while ((s = bufferedReader.readLine())!=null){
                System.out.println(s);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
