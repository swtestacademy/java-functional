package functional.interfaces;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

/**
 * Supplier does not allow an input, it returns value based on defined type.
 * It is like a function without parameter, with return type.
 */
public class SupplierInterface {
    //Supplier function declarations.
    Supplier<String>  textSupplier     = () -> "Hello SW Test Academy!";
    Supplier<Integer> numberSupplier   = () -> 1234;
    Supplier<Double>  randomSupplier   = () -> Math.random();
    Supplier<Double>  randomSupplierMR = Math::random; //With Method Reference (MR)

    @Test
    public void supplierTest() {
        //Calling Supplier functions.
        System.out.println(textSupplier.get());
        System.out.println(numberSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplierMR.get());
    }
}
