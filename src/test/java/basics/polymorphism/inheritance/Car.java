package basics.polymorphism.inheritance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Car {

    private String name = null;

    public void speedUp() {
        System.out.println("I make 100 meters in 6 seconds!");
    }

    public void consumeEnergy() {
        System.out.println("I consume oil energy!");
    }
}
