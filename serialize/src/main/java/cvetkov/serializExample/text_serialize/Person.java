package cvetkov.serializExample.text_serialize;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("age")
    private final int age;
    @JsonProperty("first_name") //можно название и не писать тогда он будет такое название поля брать
    private final String name;
    @JsonProperty("hidden_field")
    private final String hidden;

    @JsonCreator
    public Person(@JsonProperty("age") int age,
                  @JsonProperty("first_name") String name,
                  @JsonProperty("hidden_field") String hidden) {
        this.age = age;
        this.name = name;
        this.hidden = hidden;
    }
}
