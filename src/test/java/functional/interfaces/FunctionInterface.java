package functional.interfaces;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

/**
 * Function takes an input, it returns defined type.
 * It is like a function with parameter, with a return type. First param is input, second is return type.
 */
public class FunctionInterface {
    //FunctionInterface function declarations.
    Function<String, String>  toUpperCase = (text) -> text.toUpperCase();
    Function<String, String>  toLowerCase = (text) -> text.toLowerCase();
    Function<Integer, Double> log10       = (number) -> Math.log10(number);

    //Method Reference Declarations
    Function<String, String>  toUpperCaseMR = String::toUpperCase;
    Function<String, String>  toLowerCaseMR = String::toLowerCase;
    Function<Integer, Double> log10MR       = Math::log10;

    @Test
    public void functionTest() {
        //Calling functions.
        String upperCaseResult = toUpperCase.apply("hello sw test academy!");
        Double log10Result = log10.apply(10000);

        System.out.println(upperCaseResult);
        System.out.println(log10Result);
    }

    @Test
    public void functionChainWithAndThen() {
        //Function chaining. First do the first function then do the second one.
        String chainResult1 = toUpperCase.andThen(toLowerCase).apply("heLLo sW teSt ACadEmy!");
        String chainResult2 = toLowerCase.andThen(toUpperCase).apply("heLLo sW teSt ACadEmy!");

        System.out.println(chainResult1);
        System.out.println(chainResult2);
    }

    @Test
    public void functionChainWithCompose() {
        //Function chaining. First do the second function then do the first one. Vise versa of andThen.
        String chainResult1 = toUpperCase.compose(toLowerCase).apply("heLLo sW teSt ACadEmy!");
        String chainResult2 = toLowerCase.compose(toUpperCase).apply("heLLo sW teSt ACadEmy!");

        System.out.println(chainResult1);
        System.out.println(chainResult2);
    }

}
