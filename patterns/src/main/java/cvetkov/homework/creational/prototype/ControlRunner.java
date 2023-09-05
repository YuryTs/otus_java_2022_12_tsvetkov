package cvetkov.homework.creational.prototype;

public class ControlRunner {
    public static void main(String[] args) {
        Project master = new Project(1, "myProject");
        System.out.println(master);

//        Project masterClone = (Project) master.copy();
//        System.out.println(masterClone);

        ProjectFactory factory = new ProjectFactory(master);
        Project masterClone = factory.cloneProject();
        System.out.println(masterClone);
    }
}
