package cvetkov.homework.behavioral.observer;

public class Demo {
    public static void main(String[] args) {
        var producer = new EventProducer();
        var consumerA = new ConsumerA();
        var consumerB = new ConsumerB();
        var myListener = new MyListener();

        producer.addListener(consumerA);
        producer.addListener(myListener);
        producer.addListener(consumerB.getListener());

        producer.event("eventA");
        producer.event("eventB");

        System.out.println("producer size = {}" + producer.getListeners().size());

        //Критически важно удалять, когда не нужны
        producer.removeListener(consumerA);
        producer.removeListener(consumerB.getListener());
        producer.removeListener(myListener);

        producer.event("eventC");
        producer.event("eventD");
        System.out.println("producer size = {}" + producer.getListeners().size());
    }
}
