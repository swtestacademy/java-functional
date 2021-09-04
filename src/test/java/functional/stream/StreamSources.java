package functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Stream sources as List, Set, Array, Map, Stream.of(), etc.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamSources {

    @Test
    @Order(1)
    public void streamOfTest() {
        Stream.of(4, 2, 3, 5, 9, 6, 1, 8, 7)
            .sorted()
            .forEach(System.out::println);
    }

    @Test
    @Order(2)
    public void streamListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);

        list.stream()
            .sorted()
            .forEach(System.out::println);
    }

    @Test
    @Order(3)
    public void streamSetTest() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1); //Set does not allow duplicate elements.
        set.add(4);
        set.add(3);
        set.add(2);

        set.stream()
            .sorted()
            .forEach(System.out::println);
    }

    @Test
    @Order(4)
    public void streamArrayTest() {
        int[] array = { 1, 4, 3, 2 };

        Arrays.stream(array)
            .sorted()
            .forEach(System.out::println);
    }

    @Test
    @Order(5)
    public void streamMapTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Ronaldo", 36);
        map.put("Messi", 33);
        map.put("Ozil", 32);
        map.put("Xavi", 41);

        System.out.println("--EntrySet Test--");
        map.entrySet()
            .stream()
            .filter(footballer -> footballer.getValue() > 32)
            .forEach(System.out::println);

        System.out.println("\n--KeySet Test--");
        map.keySet()
            .stream()
            .filter(footballerName -> footballerName.contains("z"))
            .forEach(System.out::println);

        System.out.println("\n--Values Test--");
        map.values()
            .stream()
            .filter(footballerAge -> footballerAge > 33)
            .forEach(System.out::println);
    }
}
