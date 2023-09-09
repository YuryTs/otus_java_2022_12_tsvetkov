package cvetkov.homework.behavioral.chain3;

public abstract class Notifiere {
    private int priority;
    private Notifiere nextNotifier;

    public Notifiere(int priority) {
        this.priority = priority;
    }

    public void setNextNotifier(Notifiere nextNotifier) {
        this.nextNotifier = nextNotifier;
    }

    public void notifyManager(String message, int level){
        if(level >= priority){
            write(message);
        }
        if(nextNotifier!=null){
            nextNotifier.notifyManager(message, level);
        }
    }
    public abstract void write(String message);
}
