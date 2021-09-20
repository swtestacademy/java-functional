package functional.interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Consumer takes an input, it does not return value.
 * It is like a function with parameter, without return type.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConsumerInterface {
    //Consumer function declarations.
    Consumer<String> upperCaseConsumer = (text) -> System.out.println(text.toUpperCase());
    Consumer<String> lowerCaseConsumer = (text) -> System.out.println(text.toLowerCase());
    Consumer<Double> logOfTenConsumer  = (number) -> System.out.println(Math.log10(number));

    //BiConsumer takes two parameters and does not return anything!
    BiConsumer<Integer, Integer> powConsumer = (base, power) -> System.out.println(Math.pow(base, power));

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown(){
        System.out.println();
    }

    @Order(1)
    @Test
    public void consumerTest() {
        //Calling Consumer functions.
        upperCaseConsumer.accept("Hello SW Test Academy!");
        lowerCaseConsumer.accept("Hello SW Test Academy!");
        logOfTenConsumer.accept(1000.00);
    }

    @Order(2)
    @Test
    public void biConsumerTest() {
        //Calling BiConsumer function.
        powConsumer.accept(3,2);
    }

    @Order(3)
    @Test
    public void consumerChainTest() {
        //Consumer chaining with andThen method.
        upperCaseConsumer
            .andThen(lowerCaseConsumer)
            .accept("Hello SW Test Academy!");
    }
}
