package basics.polymorphism.inheritance;

public abstract class Car {

    private String name = null;

    public void speedUp(){
        System.out.println("I make 100 meters in 6 seconds!");
    }

    public void consumeEnergy(){
        System.out.println("I consume oil energy!");
    }
}
