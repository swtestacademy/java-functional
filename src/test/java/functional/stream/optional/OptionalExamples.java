package functional.stream.optional;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class OptionalExamples {

    /**
     * If the method returns null print 0, if not print the returned integer.
     */
    @Test
    public void optionalTest() {
        String result1 = returningNull().isPresent() ? returningNull().get() : "Value is null or empty!";
        String result2 = returningEmpty().isPresent() ? returningEmpty().get() : "Value is null or empty!";
        String result3 = returningString().isPresent() ? returningString().get() : "Value is null or empty!";
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    private Optional<String> returningNull() {
        return Optional.ofNullable(null);
    }

    private Optional<String> returningEmpty() {
        return Optional.empty();
    }

    private Optional<String> returningString() {
        return Optional.of("SW Test Academy!");
    }
}
