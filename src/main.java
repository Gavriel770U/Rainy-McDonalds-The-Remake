import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome!");

        ArrayList<FallingObject> fallingObjects = new ArrayList<>();
        Player player = new Player(Settings.FRAME_WIDTH.value / 2, 400, 160, 160, 10, 0, "./resources/player.png");

        fallingObjects.add(new FallingObject (
            100, 0, 100, 100, 5, 10, "./resources/burger.png"
        ));

        new Frame (
            "./resources/background.png",
            player,
            fallingObjects
        );
    }
}