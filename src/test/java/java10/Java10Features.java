package java10;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * New JAVA 10 Features: Var, Collectors API Changes.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Java10Features {
    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    void teardown() {
        System.out.println();
    }

    /**
     * We can use var only in declarations. It is not allowed for null and cannot be used for parameters or return types.
     * It is not a reserved keyword.
     * We cannot use var for Lambda declarations.
     */
    @Test
    @Order(1)
    public void varTest() {
        var number = 20;
        var numberList = List.of(1, 2, 3, 4);
        var footballerMap = Map.of(1, "Ronaldo", 2, "Messi");
        var var = "SW Test Academy!"; //Var is not a reserved keyword.

        //var text = null; -> null is not allowed for var declaration.
        //var multiply = (number) -> number * number; //Var is not allowed for lambda declarations!

        System.out.println(number);
        System.out.println(numberList);
        System.out.println(footballerMap);
        System.out.println(var);
    }

    @Test
    @Order(2)
    public void collectorsAPITest() {
        var list1 = List.of(1,2,3);

        var list2 = list1.stream()
            .map(number -> number*number)
            .collect(Collectors.toUnmodifiableList());

        Assertions.assertThrows(UnsupportedOperationException.class, () -> list2.add(5)); //Throws exception.

        var list3 = list1.stream()
            .map(number -> number*number)
            .collect(Collectors.toList());
        list3.add(5);

        Assertions.assertTrue(list3.contains(5));
    }
}
