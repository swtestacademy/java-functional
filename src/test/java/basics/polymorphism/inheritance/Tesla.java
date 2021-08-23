package basics.polymorphism.inheritance;

public class Tesla extends Car {
    @Override
    public void speedUp() {
        System.out.println("I make 100 meters in 3 seconds!");
    }

    @Override
    public void consumeEnergy() {
        System.out.println("I consume electric energy!");
    }
}
