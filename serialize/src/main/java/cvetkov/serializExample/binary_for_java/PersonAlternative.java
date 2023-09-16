package cvetkov.serializExample.binary_for_java;

import java.io.InputStream;
import java.io.OutputStream;

public class PersonAlternative {
    private int age;
    private String name;
    private transient String hidden;
    public void write(OutputStream out){
        //сюда записываем необходимые поля в том же порядке
    }

    public static Person read(InputStream in){
        //тоже самое записываем в том же порядке поля
        return null;
    }
}
