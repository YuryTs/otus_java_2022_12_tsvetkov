package cvetkov.serializExample.text_serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.file.Path;

public class Demo {
    public static void main(String[] args) throws IOException {


        Person in = new Person(24, "Yurii", "hidden");
        String json = serialize(in);
        Person out = deserialize(json);
    }

    //вообще все нужно делать в try-catch

        private static String serialize (Person person) throws IOException {
            ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
            String json = objectWriter.writeValueAsString(person);
            System.out.println("serialize: \n" + json);
            return json;
        }

        private static Person deserialize (String json) throws IOException {
            System.out.println(json);
            ObjectMapper objectMapper = new ObjectMapper();
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println("deserialize: " + person);
            return person;
        }
}
