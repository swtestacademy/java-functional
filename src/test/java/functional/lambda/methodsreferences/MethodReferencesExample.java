package functional.lambda.methodsreferences;

import org.junit.jupiter.api.Test;

public class MethodReferencesExample {
    @Test
    public void lambdaWithoutMethodReference(){
        //Function definition with lambda without method reference
        PrintService printUpperCase = text -> text.toUpperCase();

        //Function call
        String upperCaseText = printUpperCase.apply("software test academy");

        //Print the result
        System.out.println(upperCaseText);
    }

    @Test
    public void lambdaWithMethodReference(){
        //Function definition with lambda with method reference
        PrintService printUpperCase = String::toUpperCase;

        //Function call
        String upperCaseText = printUpperCase.apply("software test academy");

        //Print the result
        System.out.println(upperCaseText);
    }
}
