package java12to17.switchexpressions;

import static java12to17.switchexpressions.Position.BENCH;
import static java12to17.switchexpressions.Position.DEFENCE;
import static java12to17.switchexpressions.Position.FORWARD;
import static java12to17.switchexpressions.Position.GOALKEEPER;
import static java12to17.switchexpressions.Position.MIDFIELDER;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwitchExpression {
    private Map<Integer, Position> positionMap = new HashMap<>();
    private int                    randomNumber;
    private Position               randomPosition;

    @BeforeEach
    public void setup(TestInfo testInfo) {
        if (!testInfo.getDisplayName().contains("repetition")) System.out.println("\nTest name: " + testInfo.getDisplayName());
        positionMap.put(1, GOALKEEPER);
        positionMap.put(2, DEFENCE);
        positionMap.put(3, MIDFIELDER);
        positionMap.put(4, FORWARD);
        randomNumber = ThreadLocalRandom.current().nextInt(1, 6);
        randomPosition = Optional.ofNullable(positionMap.get(randomNumber)).orElse(BENCH);
    }

    @AfterEach
    public void tearDown() {
        positionMap.clear();
    }

    @RepeatedTest(5)
    @Order(1)
    public void oldSwitchExpressionTest() {
        switch (randomPosition) {
            case GOALKEEPER:
                System.out.println("Buffon");
                break;
            case DEFENCE:
                System.out.println("Ramos");
                break;
            case MIDFIELDER:
                System.out.println("Messi");
                break;
            case FORWARD:
                System.out.println("Zlatan");
                break;
            default:
                System.out.println("Please select a footballer from the BENCH!");
        }
    }

    /**
     * Compared to a traditional switch, the new switch expression
     * Uses “->” instead of “:”
     * Allows multiple constants per case.
     * Does not have fall-through semantics (i.e., Does not require breaks).
     * Makes variables defined inside a case branch local to this branch.
     * A “default” branch has to be provided.
     */
    @RepeatedTest(5)
    @Order(2)
    public void newSwitchExpressionTest() {
        switch (randomPosition) {
            case GOALKEEPER -> System.out.println("Buffon");
            case DEFENCE -> System.out.println("Ramos");
            case MIDFIELDER -> System.out.println("Messi");
            case FORWARD -> System.out.println("Zlatan");
            default -> System.out.println("Please select a footballer from the BENCH!");
        }
    }

    /**
     * If the right-hand side of a single case requires more code, it can be written inside a block, and the value returned using yield.
     */
    @RepeatedTest(5)
    @Order(3)
    public void newSwitchExpressionWithAssignmentTest() {
        String footballer = switch (randomPosition) {
            case GOALKEEPER, DEFENCE -> {
                System.out.println("Defensive Footballer Selection!");
                yield "Ramos";
            }
            case MIDFIELDER, FORWARD -> {
                System.out.println("Offensive Footballer Selection!");
                yield "Messi";
            }
            default -> "Please select a footballer from the BENCH!";
        };
        System.out.println(footballer);
    }
}
