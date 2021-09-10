package java12to17.textblocks;

import org.junit.jupiter.api.Test;

public class TextBlocks {
    /**
     * A text block is opened by three double quotes """ followed by a line break, and closed by three double-quotes.
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
     * Trailing white space is removed from every line, which can be prevented by using the new escape sequence \s.
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
     * Inserting variables into a text block can be done as usual with the static method String::format,
     * or with the new instance method String::formatted
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
