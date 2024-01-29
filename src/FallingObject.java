public class FallingObject extends BaseObject
{
    public FallingObject(final int x, final int y, final int width, final int height, final double velocity, final double acceleration, final String fallingObjectPath)    
    {
        super(x, y, width, height, velocity, acceleration, fallingObjectPath);
    }

    public void fall(final double time)
    {
        this.y = (int)(this.y0 + this.velocity0 * time + 0.5 * this.acceleration * time * time);
    }
}
