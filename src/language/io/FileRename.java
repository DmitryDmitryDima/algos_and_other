package language.io;

import java.io.File;

public class FileRename {

    public static void main(String[] args) {
        rename();
    }

    public static void rename(){
        String oldPath=  "C:/Users/User/Desktop/filebase/file.bat";
        String newPath = "C:/Users/User/Desktop/filebase/file.bat.uuid.delete";

        File file = new File(oldPath);
        file.renameTo(new File(newPath));
    }
}
