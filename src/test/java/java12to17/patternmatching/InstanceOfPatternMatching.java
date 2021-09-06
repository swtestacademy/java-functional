package java12to17.patternmatching;

import org.junit.jupiter.api.Test;


public class InstanceOfPatternMatching {
    /**
     * Pattern matching for instanceof performing casts after type comparisons.
     * The scope of the variable str is limited to the if branch.
     * The variable is in scope where the pattern is guaranteed to have matched.
     */
    @Test
    public void instanceOfPatternMatchingTest(){
        Object o = "I am a string as an object";
        if (o instanceof String str) {
            System.out.println(str.toUpperCase());
        }

        //The following code is also valid:
        if (o instanceof String str && !str.isEmpty()) {
            System.out.println(str.toUpperCase());
        }

        Object obj = 123;

        //The following code is also valid:
        if (!(obj instanceof String str)) {
            throw new RuntimeException("Please provide string!");
        }
    }
}
