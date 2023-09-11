package cvetkov.homework.composite;

import java.util.ArrayList;
import java.util.List;

public class GroupResource implements Resource{
    private final List<Resource> resourceList = new ArrayList<>();

    public void addRecource(Resource resource){
        resourceList.add(resource);
    }
    @Override
    public void open() {
        resourceList.forEach(Resource::open);
    }
}
