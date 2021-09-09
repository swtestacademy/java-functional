package functional.stream.optional;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class OptionalExamples {

    private Optional<String> returnNullMessage() {
        return Optional.ofNullable(null);
    }

    private Optional<String> returnEmptyMessage() {
        return Optional.empty();
    }

    private Optional<String> returnCustomMessage() {return Optional.of("SW Test Academy!");}

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
    public void orTest() {
        String result1 = returnNullMessage().or(this::returnCustomMessage).get();
        String result2 = returnEmptyMessage().or(this::returnCustomMessage).get();
        System.out.println(result1);
        System.out.println(result2);
    }

    @Test
    public void ifPresentOrElseTest() {
        returnNullMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
        returnNullMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
        returnNullMessage().ifPresentOrElse(message -> System.out.println("The Message is: " + message), runnable);
    }
}
