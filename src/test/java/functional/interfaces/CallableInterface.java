package functional.interfaces;

import java.util.concurrent.Callable;
import java.util.function.Supplier;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * Callable does not allow an input, it returns value.
 * It is like a function without parameter, with return type.
 */
public class CallableInterface {
    //Callable function declarations.
    Callable<Double> callFunction = () -> Math.random()*100;
    Supplier<Double> supplierFunction = () -> Math.random()*100;

    @SneakyThrows
    @Test
    public void callableTest() {
        //Calling functions.
        int callResult = callFunction.call().intValue();
        int getResult = supplierFunction.get().intValue();

        System.out.println(callResult);
        System.out.println(getResult);
    }
}
