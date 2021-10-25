package java11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * isBlank, String Lines, String repeat, String strip, Files API Changes, Optional Type : isEmpty() changes comes with JAVA 11.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Java11Features {
    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    void teardown() {
        System.out.println();
    }

    @Test
    @Order(1)
    public void isBlankTest() {
        String emptyText = "";
        String emptyTextWithSpace = "  ";

        System.out.println("emptyText isEmpty result: " + emptyText.isEmpty()); //true
        System.out.println("emptyText isBlank result: " + emptyText.isBlank()); //true

        System.out.println("emptyTextWithSpace isEmpty result: " + emptyTextWithSpace.isEmpty()); //false (because it contains spaces.)
        System.out.println("emptyTextWithSpace isBlank result: " + emptyTextWithSpace.isBlank()); //true
    }

    @Test
    @Order(2)
    public void stringLinesTest() {
        String text = "Hello\nSW Test Academy\nIt is a great site!\nGo and check!";
        System.out.println(text);

        var textList = text.lines() //lines() method creates a stream.
            .collect(Collectors.toList());
        System.out.println(textList);
        Assertions.assertEquals(4, textList.size());
    }

    @Test
    @Order(3)
    public void stringRepeatTest() {
        String text = "Let's repeat!";
        System.out.println(text.repeat(3));
    }

    @Test
    @Order(4)
    public void stringStripTest() {
        char c = '\u2002';
        String text = c + " SW TEST ACADEMY ";

        System.out.println(text.trim()); //trim cannot remove unicode character.
        System.out.println(text.strip()); //strip can remove unicode character.
    }

    @SneakyThrows
    @Test
    @Order(5)
    public void filesAPITest() {
        Path path = Paths.get(ClassLoader.getSystemResource("onur.txt").getPath());
        Files.writeString(path, "SW Test Academy", StandardOpenOption.WRITE, StandardOpenOption.SYNC);
        System.out.println("The Content: " + Files.readString(path) );
        System.out.println(Files.readString(path).contains("SW Test Academy"));
    }

    @Test
    @Order(6)
    public void optionalEmptyTest1() {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Optional<Integer> optionalNumber = numbers.stream()
            .filter(number -> number > 4)
            .findFirst();

        //isPresent version
        if (optionalNumber.isPresent()) {
            System.out.println("The number: " + optionalNumber.get());
        } else {
            System.out.println("Number is not available!");
        }

        //isEmpty version
        if (optionalNumber.isEmpty()) {
            System.out.println("Number is not available!");
        } else {
            System.out.println("The number: " + optionalNumber.get());
        }
    }

    @Test
    @Order(7)
    public void optionalEmptyTest2() {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Optional<Integer> numbersGreaterThanSeven = numbers.stream()
            .filter(number -> number > 7)
            .findFirst();

        //isPresent version
        if (numbersGreaterThanSeven.isPresent()) {
            System.out.println("The number: " + numbersGreaterThanSeven.get());
        } else {
            System.out.println("Number is not available!");
        }

        //isEmpty version
        if (numbersGreaterThanSeven.isEmpty()) {
            System.out.println("Number is not available!");
        } else {
            System.out.println("The number: " + numbersGreaterThanSeven.get());
        }
    }
}
