package basics.polymorphism.inheritancepolymorphism;

import org.junit.jupiter.api.Test;

public class CarTest {
    Car tesla    = new Tesla(); //You can also declare like this: Tesla tesla = new Tesla();
    Car porsche  = new Porsche(); //You can also declare like this: Porsche porsche = new Porsche()
    Car mercedes = new Mercedes(); //You can also declare like this: Mercedes mercedes = new Mercedes();

    @Test
    public void cartTest() {
        tesla.setName("Tesla");
        System.out.println("\nTesting " + tesla.getName() + "!\n-------------------");
        tesla.speedUp();
        tesla.consumeEnergy();

        porsche.setName("Porsche");
        System.out.println("\nTesting " + porsche.getName() + "!\n-------------------");
        porsche.speedUp();
        porsche.consumeEnergy();

        mercedes.setName("Mercedes");
        System.out.println("\nTesting " + mercedes.getName() + "!\n-------------------");
        mercedes.speedUp();
        mercedes.consumeEnergy();
    }
}
