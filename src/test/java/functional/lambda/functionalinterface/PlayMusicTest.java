package functional.lambda.functionalinterface;

import org.junit.jupiter.api.Test;

public class PlayMusicTest {

    @Test
    public void playMusicWithoutLambdaTest(){
        PlayMusicService playMusicOne = new PlayMusicService() {
            @Override public void playMusic(String song) {
                System.out.println("First playing: "+ song);
            }
        };

        PlayMusicService playMusicTwo = new PlayMusicService() {
            @Override public void playMusic(String song) {
                System.out.println("Secondly playing: "+ song);
            }
        };

        playMusicOne.playMusic("Despacito");
        playMusicTwo.playMusic("Lambada");
    }

    @Test
    public void playMusicWithLambdaTest(){
        PlayMusicService playMusicOne = (song) -> System.out.println("First playing: "+ song);

        PlayMusicService playMusicTwo = (song) -> System.out.println("Secondly playing: "+ song);

        playMusicOne.playMusic("Despacito");
        playMusicTwo.playMusic("Lambada");
    }
}
