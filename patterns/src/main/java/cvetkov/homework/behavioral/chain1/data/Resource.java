package cvetkov.homework.behavioral.chain1.data;

import java.util.Objects;

public class Resource { //ресурс какой то (м.б. диск или еще что)
    private String name; //имя

    public Resource(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Resource resource = (Resource) o;
        return Objects.equals(name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
