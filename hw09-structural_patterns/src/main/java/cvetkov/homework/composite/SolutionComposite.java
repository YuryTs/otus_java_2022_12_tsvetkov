package cvetkov.homework.composite;

public class SolutionComposite {
    public static void main(String[] args) {
    Resource file1 = new SomeFile();
    Resource file2 = new SomeFile();

    Resource folder1 = new SomeFolder();
    Resource folder2 = new SomeFolder();
    Resource folder3 = new SomeFolder();

    var group = new GroupResource();

    group.addRecource(file1);
    group.addRecource(file2);
    group.addRecource(folder1);
    group.addRecource(folder2);
    group.addRecource(folder3);

    group.open();

    var group2 = new GroupResource();
    group2.addRecource(group);
    group2.addRecource(new SomeFolder());

    group2.open();
    }
}
