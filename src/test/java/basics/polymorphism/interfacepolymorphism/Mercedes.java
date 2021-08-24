package basics.polymorphism.interfacepolymorphism;

public class Mercedes implements Engine {

    @Override
    public void startEngine() {
        System.out.println("I am Mercedes! Starting the AMG Engine now!");
    }
}
