package functional.lambda.functionasparameter;

public class PlayTest {
    public static void main(String[] args) {
        //Function definition
        PlayService playIt = (name, duration, repeat) ->
            System.out.println(name.toUpperCase() + " is playing for " + duration + " minutes." + " Repeat is: " + repeat + "\n");

        //Sending the lambda function as an argument.
        testPlay(playIt);

        //Function calling by sending the function as lambda declaration.
        testPlay((name, duration, repeat) ->
            System.out.println(name.toLowerCase() + " is playing for " + duration + " minutes." + " Repeat is: " + repeat + "\n"));
    }

    //Declaring lambda function as a parameter.
    private static void testPlay(PlayService playService) {
        System.out.println("This is a song play test!");
        playService.run("Despacito", 3.20, true);

        System.out.println("This is a video play test!");
        playService.run("Messi Skills", 4.20, true);
    }
}
