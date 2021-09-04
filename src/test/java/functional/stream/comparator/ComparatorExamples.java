package functional.stream.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComparatorExamples {
    List<Footballer> footballers = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Footballer ronaldo = new Footballer("Ronaldo", "Manchester United", 36);
        Footballer messi = new Footballer("Messi", "Paris Saint German", 33);
        Footballer ozil = new Footballer("Ozil", "Fenerbahce", 32);
        footballers.add(ronaldo);
        footballers.add(messi);
        footballers.add(ozil);
    }

    /**
     * Comparator.comparing example
     */
    @Test
    public void comparatorComparingTest() {
        Optional<Footballer> youngestFootballer = footballers.stream()
            .min(Comparator.comparing(Footballer::getAge));

        Optional<Footballer> eldestFootballer = footballers.stream()
            .max(Comparator.comparing(Footballer::getAge));

        youngestFootballer.ifPresent(footballer -> System.out.println("Youngest Footballer: " + footballer));
        eldestFootballer.ifPresent(footballer -> System.out.println("Eldest Footballer: " + footballer));
    }
}
