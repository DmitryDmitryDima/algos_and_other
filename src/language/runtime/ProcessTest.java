package language.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// пример создания и уничтожения процесса (открытие блокнота - то же самое можно сделать через cmd)
public class ProcessTest {

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        System.out.println(Runtime.version());

        try {
            Process p = r.exec(new String[]{"notepad"});

            Thread.sleep(3000);
            p.destroyForcibly();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
