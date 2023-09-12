package cvetkov;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderExample {
    public static void main(String[] args) {
        String fileName = "/home/cvetkov/Рабочий стол/fileName";

        try(BufferedReader reader = new BufferedReader(//используем BufferedReader так как у FileReader нет функции прочитать сразу всю строку
                new FileReader(fileName, StandardCharsets.UTF_8))){
            String string = reader.readLine();
            System.out.println(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
