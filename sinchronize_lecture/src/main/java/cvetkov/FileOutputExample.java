package cvetkov;

import java.io.*;

public class FileOutputExample {
    public static void main(String[] args) {
        long num = 0x7766554433221100L; //есть число (8 байт) и мы хотим записать это число в файл
        String fileName = "/home/cvetkov/Рабочий стол/fileName";

        try(OutputStream outputStream = new FileOutputStream(fileName)){
            //Little-Endian - это в каком порядке нулевой байт в начало или в конец
            for (int i = 0; i < 8; i++) { //прописываем явно, но можно все это трансформировать в одну строчку исполльзуя DaеaOutputStream см закоменнтированное ниже
                if (num == 0 ){
                    outputStream.write(0x0);
                } else {
                    outputStream.write((int) (num & 0xFF)); //по маске выбирается первый бит (00) его записал и
                    num >>= 8; //сдвинул на 8, тем самым проходим по всему значению, т.е.:
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))){
//            //Big-Endian (cannot be changed for DataOutputStream) записывать будет в Биг-эндиан
//            outputStream.writeLong(num);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}