package cvetkov.homework.creational.prototype;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectFactory {
    Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    Project cloneProject(){
        return (Project) project.copy();
    }
}
