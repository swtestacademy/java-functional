package functional.lambda.functionasparameter;

//SAM: Single Abstract Method (Functional Interface annotation dictates that this interface has single abstract method.)
@FunctionalInterface
public interface PlayService {
    void run(String name, double duration, boolean repeat);
}
