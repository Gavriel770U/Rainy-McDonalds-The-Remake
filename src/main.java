import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome!");

        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        Player player = new Player(Settings.FRAME_WIDTH.value / 2, 600, 160, 160, 10, 0, "./resources/player.png");

        fallingObjects.add(new FallingObject (
            100, -100, 100, 100, 5, 10, "./resources/burger.png", "./resources/burgerchew.wav", 10, 8
        ));

        fallingObjects.add(new FallingObject (
            300, -200, 80, 100, 5, 10, "./resources/drink.png", null, 8, 6
        ));

        fallingObjects.add(new FallingObject (
            500, -400, 100, 100, 5, 10, "./resources/blackburger.png", "./resources/burgerchew.wav", -10, -8
        ));


        new Frame (
            "./resources/background.png",
            player,
            fallingObjects
        );
    }
}