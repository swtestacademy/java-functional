package functional.stream.comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Footballer {
    String name;
    String team;
    int    age;

    @Override public String toString() {
        return "Footballer{" +
            "name='" + name + '\'' +
            ", team='" + team + '\'' +
            ", age=" + age +
            '}';
    }
}
