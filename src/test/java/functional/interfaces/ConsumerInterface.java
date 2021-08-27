package functional.interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * Consumer takes an input, it does not return value.
 * It is like a function with parameter, without return type.
 */
public class ConsumerInterface {
    //Consumer function declarations.
    Consumer<String> upperCaseConsumer = (text) -> System.out.println(text.toLowerCase());
    Consumer<String> lowerCaseConsumer = (text) -> System.out.println(text.toUpperCase());
    Consumer<Double> logOfTenConsumer  = (number) -> System.out.println(Math.log10(number));

    //BiConsumer takes two parameters and does not return anything!
    BiConsumer<Integer, Integer> powConsumer = (base, power) -> System.out.println(Math.pow(base, power));

    @Test
    public void consumerTest() {
        //Calling Consumer functions.
        upperCaseConsumer.accept("Hello SW Test Academy!");
        lowerCaseConsumer.accept("Hello SW Test Academy!");
        logOfTenConsumer.accept(1000.00);
    }

    @Test
    public void biConsumerTest() {
        //Calling BiConsumer function.
        powConsumer.accept(3,2);
    }

    @Test
    public void consumerChainTest() {
        //Consumer chaining with andThen method.
        upperCaseConsumer
            .andThen(lowerCaseConsumer)
            .accept("Hello SW Test Academy!");
    }
}
