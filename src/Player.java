public class Player extends BaseObject
{    
    public Player(final int x, final int y, final int width, final int height, final double velocity, final double acceleration, final String playerPath)
    {
        super(x, y, width, height, velocity, acceleration, playerPath);

    }

    public void move(final double time, final byte direction)
    {
        this.x += direction * this.velocity;
    }
}
