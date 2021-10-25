package java12to17.switchexpressions;

import static java12to17.switchexpressions.Position.BENCH;
import static java12to17.switchexpressions.Position.DEFENCE;
import static java12to17.switchexpressions.Position.GOALKEEPER;
import static java12to17.switchexpressions.Position.MIDFIELDER;
import static java12to17.switchexpressions.Position.STRIKER;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwitchExpression {
    private Map<Integer, Position> positionMap = new HashMap<>();
    private int                    randomNumber;
    private Position               randomPosition;

    @BeforeEach
    public void setup() {
        positionMap.put(1, GOALKEEPER);
        positionMap.put(2, DEFENCE);
        positionMap.put(3, MIDFIELDER);
        positionMap.put(4, STRIKER);
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
                System.out.println("Goal Keeper: Buffon");
                break;
            case DEFENCE:
                System.out.println("Defence: Ramos");
                break;
            case MIDFIELDER:
                System.out.println("Midfielder: Messi");
                break;
            case STRIKER:
                System.out.println("Striker: Zlatan");
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
            case GOALKEEPER -> System.out.println("Goal Keeper: Buffon");
            case DEFENCE -> System.out.println("Defence: Ramos");
            case MIDFIELDER -> System.out.println("Midfielder: Messi");
            case STRIKER -> System.out.println("Striker: Zlatan");
            default -> System.out.println("Please select a footballer from the BENCH!");
        }
    }

    /**
     * If the right-hand side of a single case requires more code, it can be written inside a block, and the value is returned using yield.
     */
    @RepeatedTest(5)
    @Order(3)
    public void newSwitchExpressionWithAssignmentTest() {
        String footballer = switch (randomPosition) {
            case GOALKEEPER, DEFENCE -> {
                System.out.println("Defensive Footballer Selection!");
                yield "Defence: Ramos";
            }
            case MIDFIELDER, STRIKER -> {
                System.out.println("Offensive Footballer Selection!");
                yield "Midfielder: Messi";
            }
            default -> "Please select a footballer from the BENCH!";
        };
        System.out.println(footballer);
    }
}
