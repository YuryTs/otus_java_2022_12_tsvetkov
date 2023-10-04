package cvetkov.homework.facade;


public class SolutionFacade {
     public static void main(String[] args) {

          var system1 = new PushNotification();
          var system2 = new SMSNotification();

          var facade = new Facade(system1, system2);
          facade.simpleNotify();

     }
}
