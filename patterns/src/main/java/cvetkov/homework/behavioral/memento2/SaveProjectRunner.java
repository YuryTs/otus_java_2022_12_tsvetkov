package cvetkov.homework.behavioral.memento2;

public class SaveProjectRunner {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHubRepo = new GitHubRepo();

        System.out.println("Creating new project. Version 1.0");

        project.setVersionAndDate("Version 1.0");

        System.out.println(project);
        System.out.println("Saving current version to gitHub...");

        gitHubRepo.setSave(project.save());

        System.out.println("Updating project to Version 1.1");
        System.out.println("Writing poor code...");

        Thread.sleep(5000);

        project.setVersionAndDate("Version 1.1.");

        System.out.println(project);
        System.out.println("Something wrong!!!");
        System.out.println("Rolling back to Version 1.0");

        project.load(gitHubRepo.getSave());

        System.out.println("Project after rollback:");
        System.out.println(project);
    }
}
