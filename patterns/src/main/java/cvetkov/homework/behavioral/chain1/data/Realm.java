package cvetkov.homework.behavioral.chain1.data;

import java.util.HashSet;

public class Realm {

    private final HashSet<Resource> resourceSet = new HashSet<>(); //список ресурсов которыми (уникальный)
    private String name;

    public Realm(final String name) {
        this.name = name;
    }

    public void addResource(Resource resource) {
        resourceSet.add(resource);
    }

    public void removeResource(Resource resource) {
        resourceSet.remove(resource);
    }

    public boolean checkResource(Resource resource) {
        return resourceSet.contains(resource);
    }

    public String getName() {
        return name;
    }
}