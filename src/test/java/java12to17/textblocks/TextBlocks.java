package java12to17.textblocks;

import org.junit.jupiter.api.Test;

public class TextBlocks {
    /**
     * A text block can be declared by starting with three double quotes """ which should be followed by a line break and
     * closed by three double quotes again.
     */
    @Test
    public void textBlocksTest() {
        String textBlockFootballers = """
            Footballers
              with double space indentation
                and "SW TEST ACADEMY TEAM" Rocks!
            """;
        System.out.println(textBlockFootballers);
    }

    /**
     * We can make the same text one-liner with the "\" character. Let's see the example below.
     */
    @Test
    public void textBlocksNoLineBreaksTest() {
        String textBlockFootballers = """
            Footballers \
            with double space indentation \
            and "SW TEST ACADEMY TEAM" Rocks! \
            """;
        System.out.println(textBlockFootballers);
    }

    /**
     * We can insert variables into a text block by using the static method String::format or with the String::formatted.
     */
    @Test
    public void textBlocksInsertingVariablesTest() {
        String textBlockFootballers = """
            Footballers
              with double space indentation
                and "%s" Rocks!
            """.formatted("SW TEST ACADEMY TEAM");
        System.out.println(textBlockFootballers);
    }
}
