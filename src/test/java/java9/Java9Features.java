package java9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * New JAVA 9 Features: TakeWhile, DropWhile, Immutable List, Immutable Set, Immutable Map, List.of(), Set.of(), Map.of() examples.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Java9Features {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Collections.addAll(numbers, 1, 2, 4, 5, 7, 6, 8, 3, 9, 10);
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
    }

    /**
     * TakeWhile: It processes the elements until the condition satisfies. Then stops processing.
     * That's why it does not process 3 even it is smaller than 6.
     */
    @Test
    @Order(1)
    public void takeWhileExample() {
        numbers.stream()
            .takeWhile(numbers -> numbers < 6) //Prints: 1 2 4 5
            .forEach(System.out::println);
    }

    /**
     * DropWhile: It does not process the elements which does not satisfy the condition.
     * Then starts to process the other elements regardless of conditions. That's why it processes 3 even it is smaller than 6.
     */
    @Test
    @Order(2)
    public void dropWhileExample() {
        numbers.stream()
            .dropWhile(numbers -> numbers < 6) //Prints: 7 6 8 3 9 10
            .forEach(System.out::println);
    }

    /**
     * Immutable List: List.of() declaration creates a list which is an immutable (constant) list.
     */
    @Test
    @Order(3)
    public void immutableList() {
        List<Integer> listOf = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(listOf);

        //List.of() creates immutable (constant) list.
        Assertions.assertThrows(UnsupportedOperationException.class, () -> listOf.add(7));
    }

    /**
     * Immutable Set: Set.of() declaration creates a set which is an immutable (constant) set.
     */
    @Test
    @Order(4)
    public void immutableSet() {
        Set<Integer> setOf = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(setOf); //Note: Set does not maintain the order.

        //Set.of() creates immutable (constant) set.
        Assertions.assertThrows(UnsupportedOperationException.class, () -> setOf.add(7));
    }

    /**
     * Immutable Map: Map.of() declaration creates a map which is an immutable (constant) map.
     */
    @Test
    @Order(5)
    public void immutableMap() {
        Map<Integer, String> mapOf = Map.of(1, "Ronaldo", 2, "Messi");
        System.out.println(mapOf);

        //Map.of() creates immutable (constant) map.
        Assertions.assertThrows(UnsupportedOperationException.class, () -> mapOf.put(3, "Ozil"));
    }
}
