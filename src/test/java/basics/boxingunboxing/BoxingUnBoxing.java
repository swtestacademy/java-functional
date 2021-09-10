package basics.boxingunboxing;

import org.junit.jupiter.api.Test;

public class BoxingUnBoxing {
    @Test
    public void boxingUnBoxing() {
        //Boxing
        int counter = 30;
        Integer boxedCounter = counter;
        System.out.println("Boxed Counter: " + boxedCounter);

        //UnBoxing
        int unboxedCounter = boxedCounter;
        System.out.println("Unboxed Counter: " + unboxedCounter);
    }
}
