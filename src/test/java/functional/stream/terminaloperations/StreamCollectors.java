package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Collect operations are ToList, ToSet, ToMap, and JoinAll.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamCollectors {
    List<Integer> numbers = new ArrayList<>();
    List<String>  texts   = new ArrayList<>();

    @BeforeEach
    public void setup() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        texts.add("Ronaldo");
        texts.add("Messi");
        texts.add("Zlatan");
        texts.add("Pele");
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
        texts.clear();
        System.out.println("");
    }

    @Test
    @Order(1)
    public void streamCollectorsToListTest() {
        List<Integer> numberList = numbers.stream()
            .filter(number -> number < 8) //Filter numbers which are smaller than 8.
            .filter(number -> number % 2 == 0) //Filter even numbers.
            .skip(1) //Skip the first filtered number.
            .map(number -> number * number) //Transform the number to number*number
            .collect(Collectors.toList());

        System.out.println("Number List: " + numberList);
    }

    /**
     * Set does not have duplicate elements.
     */
    @Test
    @Order(2)
    public void streamCollectorsToSetNumbersTest() {
        numbers.add(3);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(4);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(6);
        numbers.add(5);
        System.out.println("Number List: " + numbers);

        Set<Integer> numberSet = numbers.stream()
            .filter(number -> number < 6)
            .collect(Collectors.toSet());

        System.out.println("Number Set: " + numberSet);
    }

    @Test
    @Order(3)
    public void streamCollectorsToSetTextsTest() {
        texts.add("Ronaldo");
        texts.add("Ronaldo");
        texts.add("Pele");
        System.out.println("Text List: " + texts);

        Set<String> textSet = texts.stream()
            .filter(text -> text.length() < 12)
            .collect(Collectors.toSet());

        System.out.println("Text Set: " + textSet);
    }

    /**
     * Joining the elements with our without delimiters.
     */
    @Test
    @Order(4)
    public void streamCollectorsJoiningTest() {
        System.out.println("Text List: " + texts);

        String joinedText = texts.stream()
            .filter(text -> text.length() < 12)
            .collect(Collectors.joining(" - "));

        System.out.println("Joined Text: " + joinedText);
    }

    /**
     * Grouping elements with defined rules.
     */
    @Test
    @Order(5)
    public void streamCollectToGroupingByLengthTest() {
        texts.add("Ozil");
        texts.add("Zidane");
        texts.add("Iniesta");
        System.out.println("Text List: " + texts);

        //Group By Length
        Map<Integer, List<String>> groupByLength = texts.stream()
            .collect(Collectors.groupingBy(String::length));

        //Group By Contains
        Map<Boolean, List<String>> groupByContainsCharZ = texts.stream()
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(text -> text.contains("z")));

        //Group By Last Character
        Map<Character, List<String>> groupByLastCharacter = texts.stream()
            .collect(Collectors.groupingBy(text -> text.charAt(text.length()-1)));

        System.out.println("groupBy Length: " + groupByLength);
        System.out.println("groupBy Contains Character Z: " + groupByContainsCharZ);
        System.out.println("groupBy Last Character: " + groupByLastCharacter);
    }
}
