package functional.stream.intermediateoperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * If you have list of list then you can use flatmap to convert the list of list to a list.
 */
public class StreamFlatMap {
    List<Integer>       numbersList1         = new ArrayList<>();
    List<Integer>       numbersList2         = new ArrayList<>();
    List<Integer>       numbersList3         = new ArrayList<>();
    List<List<Integer>> listOfAllNumberLists = new ArrayList<>();

    @BeforeEach
    public void setup() {
        numbersList1.add(1);
        numbersList1.add(2);
        numbersList1.add(3);
        numbersList2.add(4);
        numbersList2.add(5);
        numbersList2.add(6);
        numbersList3.add(7);
        numbersList3.add(8);
        numbersList3.add(9);
        numbersList3.add(10);
        listOfAllNumberLists.add(numbersList1);
        listOfAllNumberLists.add(numbersList2);
        listOfAllNumberLists.add(numbersList3);
    }

    @Test
    public void flatMapTest() {
        listOfAllNumberLists.stream()
            .flatMap(Collection::stream)
            .filter(number -> number > 8)
            .peek(number -> System.out.println("Filtered number: " + number))
            .map(number -> number * number)
            .forEach(System.out::println);
    }
}
