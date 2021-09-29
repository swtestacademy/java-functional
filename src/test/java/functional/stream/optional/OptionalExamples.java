package functional.stream.optional;

import java.util.Optional;
import java.util.function.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionalExamples {
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
    public void isPresentTest() {
        String result1 = returnNullMessage().isPresent() ? returnNullMessage().get() : "Value is null or empty!";
        String result2 = returnEmptyMessage().isPresent() ? returnEmptyMessage().get() : "Value is null or empty!";
        String result3 = returnCustomMessage().isPresent() ? returnCustomMessage().get() : "Value is null or empty!";
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Test
    public void isEmptyTest() {
        String result1 = returnNullMessage().isEmpty() ? "Value is null or empty!" : returnNullMessage().get();
        String result2 = returnEmptyMessage().isEmpty() ? "Value is null or empty!" : returnEmptyMessage().get();
        String result3 = returnCustomMessage().isEmpty() ? "Value is null or empty!" : returnCustomMessage().get();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Test
    public void orTest() {
        Optional<String> result1 = returnNullMessage().or(optionalTextSupplier);
        Optional<String> result2 = returnEmptyMessage().or(optionalTextSupplier);
        System.out.println(result1);
        System.out.println(result2);
    }

    @Test
    public void orElseTest1() {
        String result1 = returnNullMessage().orElse(customMessageSupplier.get());
        String result2 = returnEmptyMessage().orElse(customMessageSupplier.get());
        System.out.println(result1);
        System.out.println(result2);
    }

    @Test
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
    public void orElse_vs_OrElseGet_Test() {
        System.out.println("orElse() Test Starting!");
        String orElseResult = returnCustomMessage().orElse(anotherTextSupplier.get());
        System.out.println("Result of orElse(): " + orElseResult + "\norElse() Test Finished!\n");

        System.out.println("orElseGet() Test Starting!");
        String orElseGetResult = returnCustomMessage().orElseGet(anotherTextSupplier);
        System.out.println("Result of orElseGet(): " + orElseGetResult + "\norElseGet() Test Finished!");
    }

    @Test
    public void orElseThrow() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> returnNullMessage().orElseThrow(IllegalArgumentException::new));
        Assertions.assertThrows(IllegalArgumentException.class, () -> returnEmptyMessage().orElseThrow(IllegalArgumentException::new));
        Assertions.assertEquals("SW Test Academy!", returnCustomMessage().orElseThrow(IllegalArgumentException::new));
    }

    @Test
    public void ifPresent() {
        returnNullMessage().ifPresent(message -> System.out.println("The Message is: " + message));
        returnEmptyMessage().ifPresent(message -> System.out.println("The Message is: " + message));
        returnCustomMessage().ifPresent(message -> System.out.println("The Message is: " + message));
    }

    @Test
    public void ifPresentOrElseTest() {
        returnNullMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
        returnEmptyMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
        returnCustomMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
    }
}
