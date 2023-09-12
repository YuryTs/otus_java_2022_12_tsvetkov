package cvetkov.serializExample.binary_for_java;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PersonExteralizable implements Externalizable {
    private static final long serialVersionUID = 45432567545543L;
    private int age;
    private String name;

    //transient - не сериализуется
    private transient String hidden;

    public PersonExteralizable(int age, String name, String hidden) {
        this.age = age;
        this.name = name;
        this.hidden = hidden;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(age);
        out.writeUTF(name);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        age = in.readInt();
        name = in.readUTF();

    }
}
