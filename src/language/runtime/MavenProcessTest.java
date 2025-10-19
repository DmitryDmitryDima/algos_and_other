package language.runtime;

import javax.swing.*;
import java.io.*;

public class MavenProcessTest {

    // проект для примера обычной компиляции
    private static final String directory= "C:/Users/User/Desktop/filebase/dima/projects/demo3/";

    // проект для примера обычной компиляции
    private static final String directory1= "C:/Users/User/Desktop/filebase/dima/projects/demo/";

    // пример компиляции и запуска скомпилированного
    public static void main(String[] args) throws Exception {

        try{
            dockerPresenceTest();
        }
        catch (Exception e){
            System.out.println("Exception "+e.getMessage()); //Cannot run program "docker": CreateProcess error=2, Не удается найти указанный файл
        }



    }

    public static void dockerPresenceTest() throws Exception{
        ProcessBuilder pb = new ProcessBuilder("docker", "--version");
        Process process = pb.start(); // ОШИБКА ТУТ


        try (final InputStream stdoutInputStream = process.getInputStream();
             final BufferedReader stdoutReader =
                     new BufferedReader(new InputStreamReader(stdoutInputStream))
        ){
            String out;
            while ((out = stdoutReader.readLine()) != null) {
                System.out.println(out);


            }
        }
        catch (Exception e){
            System.out.println("Error!");
            e.printStackTrace();
        }

        int exitCode = process.waitFor();
        if (exitCode!=0){
            System.out.println("error");
        }
    }


    public static void fatJar() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("mvn.cmd", "package");

        pb.directory(new File(directory1));
        Process process = pb.start();

        final InputStream stdoutInputStream = process.getInputStream();
        final BufferedReader stdoutReader =
                new BufferedReader(new InputStreamReader(stdoutInputStream));
        String out;
        while ((out = stdoutReader.readLine()) != null) {
            //
            System.out.println(out);
        }

        ProcessBuilder pbRun = new ProcessBuilder("java", "-jar", "target/fatjar.jar");
        pbRun.directory(new File(directory1));
        Process processRun = pbRun.start();
        final InputStream stdoutInputStreamRun = processRun.getInputStream();
        final BufferedReader stdoutReaderRun =
                new BufferedReader(new InputStreamReader(stdoutInputStreamRun));
        String outRun;
        while ((outRun = stdoutReaderRun.readLine()) != null) {
            //
            System.out.println(outRun);
        }






    }


    public static void compileClasses() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("mvn.cmd", "compile"); // for linux ("mvn", "compile");
        pb.directory(new File(directory));
        Process process = pb.start();
        final InputStream stdoutInputStream = process.getInputStream();
        final BufferedReader stdoutReader =
                new BufferedReader(new InputStreamReader(stdoutInputStream));
        String out;
        while ((out = stdoutReader.readLine()) != null) {
            //
            System.out.println(out);
        }




        ProcessBuilder pbRun = new ProcessBuilder("java", "-cp", "target/classes","com.Main");
        pbRun.directory(new File(directory));
        Process processRun = pbRun.start();
        final InputStream stdoutInputStreamRun = processRun.getInputStream();
        final BufferedReader stdoutReaderRun =
                new BufferedReader(new InputStreamReader(stdoutInputStreamRun));
        String outRun;
        while ((outRun = stdoutReaderRun.readLine()) != null) {
            //
            System.out.println(outRun);
        }
    }







}
