package basics.polymorphism.interfacepolymorphism;

public class Tesla implements Engine {
    @Override public void startEngine() {
        System.out.println("I am Tesla! Starting the Electric Engine now!");
    }
}
