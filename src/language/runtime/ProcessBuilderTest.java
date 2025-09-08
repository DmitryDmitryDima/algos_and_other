package language.runtime;

import java.io.IOException;

public class ProcessBuilderTest {

    public static void main(String...args){

        ProcessBuilder pb = new ProcessBuilder("notepad"); // or ArrayList as argument
        try {
            Process process =pb.start();

            

            Thread.sleep(3000);
            process.destroyForcibly();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
