import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome!");

        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        Player player = new Player(Settings.FRAME_WIDTH.value / 2, Settings.FRAME_HEIGHT.value - 200, 160, 160, 10, 3.0, "./resources/sprites/player.png");

        fallingObjects.add(new FallingObject (
            100, -100, 100, 100, 5, 10, "./resources/sprites/burger.png", "./resources/sounds/burgerchew.wav", 10, 8
        ));

        fallingObjects.add(new FallingObject (
            300, -200, 80, 100, 5, 10, "./resources/sprites/drink.png", "./resources/sounds/drinkswallow.wav", 8, 6
        ));

        fallingObjects.add(new FallingObject (
            100, -300, 80, 100, 5, 10, "./resources/sprites/chips.png", "./resources/sounds/chipschew.wav", 8, 8
        ));

        fallingObjects.add(new FallingObject (
            500, -400, 100, 100, 5, 10, "./resources/sprites/blackburger.png", "./resources/sounds/burgerchew.wav", -10, -8
        ));


        new Frame (
            "./resources/backgrounds/background.png",
            player,
            fallingObjects,
            "./resources/sounds/music.wav"
        );
    }
}