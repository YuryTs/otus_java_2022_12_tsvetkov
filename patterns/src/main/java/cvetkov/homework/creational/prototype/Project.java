package cvetkov.homework.creational.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project implements Copybale{
    private int id;
    private String projectName;

    public Project(int id, String projectName) {
        this.id = id;
        this.projectName = projectName;
    }

    @Override
    public Object copy() {
        Project copy = new Project(id, projectName);
        return copy;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
