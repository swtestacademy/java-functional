package basics.polymorphism.interfacepolymorphism;

public class Porsche implements Engine {

    @Override public void startEngine() {
        System.out.println("I am Porsche! Starting the Turbo Engine now!");
    }
}
