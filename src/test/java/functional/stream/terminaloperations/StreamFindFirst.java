package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamFindFirst {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
        System.out.println("");
    }

    @Test
    @Order(1)
    public void streamCountTest() {
        Optional<Integer> firstFoundNumber = numbers.stream()
            .filter(number -> number < 8) //Filter numbers which are smaller than 8.
            .filter(number -> number % 2 == 0) //Filter even numbers.
            .skip(1) //Skip the first filtered number.
            .findFirst();

        //Traditional Style
        if(firstFoundNumber.isPresent()) {
            System.out.println(firstFoundNumber.get());
        }

        //Functional Style
        firstFoundNumber.ifPresent(System.out::println);
    }

    @Test
    @Order(2)
    public void streamCountTestWithException() {
        Optional<Integer> firstFoundNumber = Optional.of(numbers.stream()
            .filter(number -> number < 8) //Filter numbers which are smaller than 8.
            .filter(number -> number % 2 == 0) //Filter even numbers.
            .skip(4) //Skip the first 4 filtered number.
            .findFirst()
            .orElseThrow(NoSuchElementException::new));

        //Functional Style
        firstFoundNumber.ifPresent(System.out::println);
    }
}
