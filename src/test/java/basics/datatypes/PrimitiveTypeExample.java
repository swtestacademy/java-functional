package basics.datatypes;

import org.junit.jupiter.api.Test;

public class PrimitiveTypeExample {
    @Test
    public void primitiveTypeExample() {
        int a = 8;
        System.out.println("Before Modify: " + a);
        modify(a);
        System.out.println("After Modify: " + a);
    }

    private static void modify(int b) {
        b--; //Here, the value of a will not change because a comes here not as reference.
    }
}
