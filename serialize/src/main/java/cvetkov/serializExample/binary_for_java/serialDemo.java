package cvetkov.serializExample.binary_for_java;

import java.io.*;

public class serialDemo {
    public static void main(String[] args) {
        Person personIn = new Person(41, "Yurii", "Hidden");
        byte[] buf = serialize(personIn); //делаем serialize в буфер (можно в файл)
        Person personOut = deserialize(buf);//из буфера десериализуем в объект
        System.out.println(personOut);
        System.out.println("__________________");

    }



    private static byte[] serialize(Person person) {

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            System.out.println("serialize: " + person);
            outputStream.writeObject(person);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Person deserialize(byte[] buf) {
        try(ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(buf))){
            Person person = (Person) inputStream.readObject();
            System.out.println("deserialized: " + person);
            return person;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
