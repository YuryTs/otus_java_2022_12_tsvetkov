package cvetkov;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class WriterExample {
    public static void main(String[] args) {
        String str = "Yurii";

        String fileName = "/home/cvetkov/Рабочий стол/fileName";
//        System.lineSeparator();

        try(Writer writer = new FileWriter(fileName, StandardCharsets.UTF_8)){
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
