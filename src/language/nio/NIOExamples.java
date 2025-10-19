package language.nio;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

public class NIOExamples {

    private static String folderPath = "C:/Users/User/Desktop/filebase/dima/projects/java/demo";
    private static String filename =  "current.log";

    public static void main(String[] args) throws IOException {

        readByLines();


    }

    // отличный метод для ленивого чтения по строкам (большие файлы)
    private static void readByLines() throws IOException {
        Path path = Path.of(folderPath, filename);

        try (var lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
    }

    private static void directoryStreamExample() throws IOException {

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of(folderPath))) {
            for (Path path:directoryStream){
                System.out.println(path);
                System.out.println(Files.isDirectory(path));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // обход вглубь, в порядке от самых глубоких слоев
        Files.walk(Path.of(folderPath)).sorted(Comparator.reverseOrder()).forEach(System.out::println);


        // обход дерева с использованием кастомного visitor
        Files.walkFileTree(Path.of(folderPath), new SimpleFileVisitor<>(){

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                System.out.println("dir "+dir);
                // выбор действия - продолжаем
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                System.out.println("file "+ file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void easyCopy() throws IOException {

        Path origin = Path.of(folderPath, filename);
        Path target = Path.of(folderPath, "copied.txt");

        Files.copy(origin, target);


    }

    // лаконичнее - все, что пишется в буфер, пишется и в файл
    // по сути - write перезаписывает те локации, которые указаны в position. Если на нуле что то стоит, то оно заменится на новое
    private static void channelWriteWithBufferMap() throws IOException{
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of(folderPath, filename),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE)) {

            // будем писать алфавит
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            for (int i = 0; i<26; i++){
                mappedByteBuffer.put((byte) ('A'+i));
            }



        }
    }

    private static void channelReWriteExample() throws IOException {

        // WRITE - начинает запись в начале, APPEND - НАЧИНАЕТ ЗАПИСЬ С КОНЦА,  CREATE - СОЗДАЕТ ФАЙЛ, ЕСЛИ ЕГО НЕ СУЩЕСТВУЕТ
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of(folderPath, filename), StandardOpenOption.WRITE)) {
            int capacity = 26;
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity); // пишем алфавит

            for (int i = 0; i<capacity; i++){
                byteBuffer.put((byte) ('A'+i));


            }
            // подготовка к записи
            byteBuffer.rewind();
            fileChannel.write(byteBuffer); // согласно опциям, файл должен существововать и будет перезаписан с нуля






        }
    }

    private static void readFromOneLargeBuffer(){

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of(folderPath, filename))) {

            long size = fileChannel.size();

            // читаем файл целиком в буфер - 0 - начало, size - конец
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0, size);

            for (int i = 0; i<size; i++){
               char c = (char) mappedByteBuffer.get(i);
               System.out.println(c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readWithBuffer(){
        Path path = Path.of(folderPath, filename);

        int count = 0;

        // подключение к файлу с целью чтения
        try (SeekableByteChannel channel = Files.newByteChannel(path)){

            // готовим буфер. который будет использоваться для чтения с канала
            ByteBuffer readBuf = ByteBuffer.allocate(128);

            do {
                count = channel.read(readBuf);

                readBuf.rewind(); // промотка, необходима для доступности данных

                for (int i = 0; i<count; i++){
                    // читаем байты и переводим в char
                    char c = (char) readBuf.get();
                    System.out.println(c);
                }



            }
            while (count!=-1);

        }
        catch (IOException e){

        }
    }
}
