package functional.stream.optional;

import java.util.Optional;
import java.util.function.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OptionalExamples {
    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown() {
        System.out.println();
    }

    private Optional<String> returnNullMessage() {
        return Optional.ofNullable(null);
    }

    private Optional<String> returnEmptyMessage() {
        return Optional.empty();
    }

    private Optional<String> returnCustomMessage() {
        return Optional.of("SW Test Academy!");
    }

    Supplier<String> customMessageSupplier = () -> "SW Test Academy!";

    Supplier<Optional<String>> optionalTextSupplier = () -> Optional.of("This is an optional text!");

    Supplier<String> anotherTextSupplier = () -> {
        System.out.println("Returning an another text.");
        return "Another Text!";
    };

    private final Runnable runnable = () -> System.out.println("Value is null or empty!");

    @Test
    @Order(1)
    public void isPresentTest() {
        String result1 = returnNullMessage().isPresent() ? returnNullMessage().get() : "Value is null or empty!";
        String result2 = returnEmptyMessage().isPresent() ? returnEmptyMessage().get() : "Value is null or empty!";
        String result3 = returnCustomMessage().isPresent() ? returnCustomMessage().get() : "Value is null or empty!";
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Test
    @Order(2)
    public void isEmptyTest() {
        String result1 = returnNullMessage().isEmpty() ? "Value is null or empty!" : returnNullMessage().get();
        String result2 = returnEmptyMessage().isEmpty() ? "Value is null or empty!" : returnEmptyMessage().get();
        String result3 = returnCustomMessage().isEmpty() ? "Value is null or empty!" : returnCustomMessage().get();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Test
    @Order(3)
    public void orTest() {
        Optional<String> result1 = returnNullMessage().or(optionalTextSupplier);
        Optional<String> result2 = returnEmptyMessage().or(optionalTextSupplier);
        Optional<String> result3 = returnCustomMessage().or(optionalTextSupplier);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Test
    @Order(4)
    public void orElseTest() {
        String result1 = returnNullMessage().orElse(customMessageSupplier.get());
        String result2 = returnEmptyMessage().orElse(customMessageSupplier.get());
        System.out.println(result1);
        System.out.println(result2);
    }

    @Test
    @Order(5)
    public void orElseGetTest() {
        String result1 = returnNullMessage().orElseGet(customMessageSupplier);
        String result2 = returnEmptyMessage().orElseGet(customMessageSupplier);
        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * In the below example the returnCustomMessage returns not null or empty value, and we will get the custom message but
     * also the object inside orElse has been created. That's why we will see the print statement inside anotherTextSupplier
     * function in below example. This is of the main difference between orElse() and orElseGet().
     */
    @Test
    @Order(6)
    public void orElse_vs_OrElseGet_Test() {
        System.out.println("orElse() Test Starting!");
        String orElseResult = returnCustomMessage().orElse(anotherTextSupplier.get());
        System.out.println("Result of orElse(): " + orElseResult + "\norElse() Test Finished!\n");

        System.out.println("orElseGet() Test Starting!");
        String orElseGetResult = returnCustomMessage().orElseGet(anotherTextSupplier);
        System.out.println("Result of orElseGet(): " + orElseGetResult + "\norElseGet() Test Finished!");
    }

    @Test
    @Order(7)
    public void orElseThrow() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> returnNullMessage().orElseThrow(IllegalArgumentException::new));
        Assertions.assertThrows(IllegalArgumentException.class, () -> returnEmptyMessage().orElseThrow(IllegalArgumentException::new));
        Assertions.assertEquals("SW Test Academy!", returnCustomMessage().orElseThrow(IllegalArgumentException::new));
    }

    @Test
    @Order(8)
    public void ifPresent() {
        returnNullMessage().ifPresent(message -> System.out.println("The Message is: " + message));
        returnEmptyMessage().ifPresent(message -> System.out.println("The Message is: " + message));
        returnCustomMessage().ifPresent(message -> System.out.println("The Message is: " + message));
    }

    @Test
    @Order(9)
    public void ifPresentOrElseTest() {
        returnNullMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
        returnEmptyMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
        returnCustomMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
    }

    @Test
    @Order(10)
    public void optionalMapExample() {
        Optional<Integer> optional1 = Optional.empty();
        System.out.println("First Example Starting!");
        optional1
            .map(num -> Math.pow(num, 3))
            .ifPresent(System.out::println);

        System.out.println("Second Example Starting!");
        Optional<Integer> optional2 = Optional.of(2);
        optional2
            .map(num -> Math.pow(num, 3))
            .ifPresent(System.out::println);
    }

    @Test
    @Order(11)
    public void optionalFilterExample() {
        System.out.println("First Example Starting!");
        Optional<String> optional1 = Optional.empty();
        optional1
            .filter(text -> text.length() > 3)
            .ifPresent(System.out::println);

        System.out.println("Second Example Starting!");
        Optional<String> optional2 = Optional.of("SW Test Academy!");
        optional2
            .filter(text -> text.contains("SW Test Academy"))
            .ifPresent(System.out::println);
    }
}