package language.runtime;

import java.io.*;

public class MavenProcessTest {

    //
    private static final String directory= "C:/Users/User/Desktop/filebase/dima/projects/demo3/";

    // пример компиляции и запуска скомпилированного
    public static void main(String[] args) throws IOException {


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
