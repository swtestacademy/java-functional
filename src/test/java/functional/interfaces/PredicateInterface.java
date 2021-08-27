package functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

/**
 * Predicate takes an input, it returns boolean value as true or false.
 * It is like a function with parameter, with boolean return type.
 */
public class PredicateInterface {
    //Predicate function declaration.
    String            sampleText        = "Hello SW Test Academy";
    Predicate<String> containsPredicate = (text) -> sampleText.contains(text);

    //BiPredicate function declaration.
    BiPredicate<String, String> containsBiPredicate   = (text, pattern) -> text.contains(pattern);
    BiPredicate<String, String> containsBiPredicateMR = String::contains; //Method reference version.

    @Test
    public void predicateTest() {
        //Calling Predicate functions.
        boolean result = containsPredicate.test("SW");
        boolean resultOfNegate = containsPredicate.negate().test("SW"); //negate is inverse operation like "does not contain".
        boolean andResult = containsBiPredicate.and(containsBiPredicate.negate()).test("SW", "SW"); //Logical AND operation.
        boolean orResult = containsBiPredicate.or(containsBiPredicate.negate()).test("SW", "SW"); //Logical OR operation.

        System.out.println(result);
        System.out.println(resultOfNegate);
        System.out.println(andResult);
        System.out.println(orResult);
    }

    @Test
    public void predicateListTest() {
        List<Predicate<String>> predicateList = new ArrayList<>();
        predicateList.add(containsPredicate);
        predicateList.add(containsPredicate.negate());

        predicateList
            .forEach(predicate -> System.out.println(predicate.test("SW")));
    }

    @Test
    public void biPredicateTest() {
        //Calling BiPredicate functions.
        boolean result = containsBiPredicate.test("Hello SW Test Academy", "SW");
        System.out.println(result);
    }
}
