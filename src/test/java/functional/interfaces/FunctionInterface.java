package functional.interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Function takes an input, it returns defined type.
 * It is like a function with parameter, with a return type. First param is input, second is return type.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FunctionInterface {
    //FunctionInterface function declarations. (Input Type, Return Type)
    Function<String, String>  toUpperCase = (text) -> text.toUpperCase();
    Function<String, String>  toLowerCase = (text) -> text.toLowerCase();
    Function<Integer, Double> log10       = (number) -> Math.log10(number);

    //Method Reference Declarations (Input Type, Return Type)
    Function<String, String>  toUpperCaseMR = String::toUpperCase;
    Function<String, String>  toLowerCaseMR = String::toLowerCase;
    Function<Integer, Double> log10MR       = Math::log10;

    //BiFunction Example (Input Type, Input Type, Return Type)
    BiFunction<Integer, Integer, Integer> powerOf = (base, power) -> (int) Math.pow(base, power);

    //UnaryOperator Example (Input and Return type are same.)
    UnaryOperator<String> appendText = (text) -> "I am appending: " + text;

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown(){
        System.out.println();
    }

    @Order(1)
    @Test
    public void functionTest() {
        //Calling functions.
        String upperCaseResult = toUpperCase.apply("hello sw test academy!");
        Double log10Result = log10.apply(10000);

        System.out.println(upperCaseResult);
        System.out.println(log10Result);
    }

    @Order(2)
    @Test
    public void functionChainWithAndThen() {
        //Function chaining. First do the first function then do the second one.
        String chainResult1 = toUpperCase.andThen(toLowerCase).apply("heLLo sW teSt ACadEmy!");
        String chainResult2 = toLowerCase.andThen(toUpperCase).apply("heLLo sW teSt ACadEmy!");

        System.out.println(chainResult1);
        System.out.println(chainResult2);
    }

    @Order(3)
    @Test
    public void functionChainWithCompose() {
        //Function chaining. First do the second function then do the first one. Vise versa of andThen.
        String chainResult1 = toUpperCase.compose(toLowerCase).apply("heLLo sW teSt ACadEmy!");
        String chainResult2 = toLowerCase.compose(toUpperCase).apply("heLLo sW teSt ACadEmy!");

        System.out.println(chainResult1);
        System.out.println(chainResult2);
    }

    @Order(4)
    @Test
    public void biFunctionTest() {
        //Calling functions.
        int result = powerOf.apply(3, 2);
        System.out.println("Power of 3 over 2 is: " + result);
    }

    @Order(5)
    @Test
    public void unaryOperatorTest(){
        //Calling UnaryOperator
        System.out.println(appendText.apply("Hello SW Test Academy!"));
    }
}
