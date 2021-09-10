package basics.polymorphism.inheritancepolymorphism;

import org.junit.jupiter.api.Test;

public class CarTest {
    Car tesla    = new Tesla();
    Car porsche  = new Porsche();
    Car mercedes = new Mercedes();

    @Test
    public void cartTest() {
        tesla.setName("Tesla");
        System.out.println("\nTesting " +  tesla.getName() + "!\n-------------------");
        tesla.speedUp();
        tesla.consumeEnergy();

        porsche.setName("Porsche");
        System.out.println("\nTesting " +  porsche.getName() + "!\n-------------------");
        porsche.speedUp();
        porsche.consumeEnergy();

        mercedes.setName("Mercedes");
        System.out.println("\nTesting " +  mercedes.getName() + "!\n-------------------");
        mercedes.speedUp();
        mercedes.consumeEnergy();
    }
}
