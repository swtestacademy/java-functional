package basics.polymorphism.interfacepolymorphism;

import org.junit.jupiter.api.Test;

public class EngineTest {

    Tesla    tesla    = new Tesla();
    Mercedes mercedes = new Mercedes();
    Porsche  porsche  = new Porsche();

    @Test
    public void cartTest() {
        System.out.println("\nTesting Tesla!\n-------------------");
        System.out.println(tesla.getVehicleType());
        tesla.startEngine();

        System.out.println("\nTesting Mercedes!\n-------------------");
        System.out.println(mercedes.getVehicleType());
        mercedes.startEngine();

        System.out.println("\nTesting Porsche!\n-------------------");
        System.out.println(porsche.getVehicleType());
        porsche.startEngine();
    }
}
