package basics.polymorphism.inheritance;

import org.junit.jupiter.api.Test;

public class CarTest {

    Car tesla = new Tesla();
    Car porsche = new Porsche();
    Car mercedes = new Mercedes();

    @Test
    public void cartTest() {
        System.out.println("Testing Tesla!\n-------------------");
        tesla.speedUp();
        tesla.consumeEnergy();

        System.out.println("\nTesting Porsche!\n-------------------");
        porsche.speedUp();
        porsche.consumeEnergy();

        System.out.println("\nTesting Mercedes!\n-------------------");
        mercedes.speedUp();
        mercedes.consumeEnergy();
    }
}
