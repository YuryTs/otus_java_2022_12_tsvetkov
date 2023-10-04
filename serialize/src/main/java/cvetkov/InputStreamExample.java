package cvetkov;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
    public static void main(String[] args) throws IOException {
        final int EOF = -1;
        String fileName = "/home/cvetkov/Рабочий стол/fileName";

//        try(InputStream inputStream = new FileInputStream(fileName)) {
//            int data;
//            while ((data = inputStream.read()) != EOF){
//                System.out.format("0x%02X ", data);
//            }
//        }

        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))){
            long num = inputStream.readLong();
            System.out.printf("0x%02X \n", num);
        }
    }
}
