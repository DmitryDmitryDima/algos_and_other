package language.io;

import java.io.File;
import java.util.Objects;

public class FileTraveler {

    public static void main(String[] args) {

        String WAY = "C:/Users/User/Desktop/filebase/dima/projects/";



        for (File file: Objects.requireNonNull(new File(WAY).listFiles())){
            if (file.isDirectory()){
                travelDirectories(file);
            }
        }



    }

    private static void travelDirectories(File parent){
        System.out.println(parent.getName()+" Parent");

        File[] children = parent.listFiles();
        if (children!=null){
            for (File f:children){
                // тут мы создаем новые сущности, вставляя в нее зависимость parent
                System.out.println("create children "+f.getName());
                if (f.isDirectory()){
                    travelDirectories(f);
                }

                // тут к детям parent мы добавляем полноценного ребенка - если f это директория
            }
        }
    }
}
