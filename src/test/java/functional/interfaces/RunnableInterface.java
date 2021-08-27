package functional.interfaces;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

/**
 * Runnable does not allow an input, it does not return value.
 * It is like a function without parameter, without return type.
 */
public class RunnableInterface {
    //Runnable function declarations.
    Runnable runFunction = () -> System.out.println("I am running!");

    @Test
    public void runnableTest() {
        //Calling Runnable functions.
        runFunction.run();
    }

    //Running Asynchronously
    public static void main(String[] args) {
        Runnable runFunction = () -> System.out.println("I am running!");

        Runnable runWithDelay = () -> {
            Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
            System.out.println("I am running Asynchronously!");
        };

        new Thread(runWithDelay).start();

        runFunction.run();
    }
}
