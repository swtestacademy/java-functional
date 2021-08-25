package functional.lambda.functionalinterface;

import org.junit.jupiter.api.Test;

public class PlayMusicServiceTest {

    @Test
    public void playMusicWithoutLambdaTest(){
        PlayMusicService playIt = new PlayMusicService() {
            @Override public void run(String song) {
                System.out.println("First playing: "+ song);
            }
        };

        playIt.run("Despacito");
    }

    @Test
    public void playMusicWithLambdaTest(){
        PlayMusicService playIt = (song) -> System.out.println("First playing: "+ song);

        playIt.run("Despacito");
    }
}
