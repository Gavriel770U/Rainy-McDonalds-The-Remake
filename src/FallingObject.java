public class FallingObject extends BaseObject
{
    public FallingObject(final int x, final int y, final int width, final int height, final double velocity, final double acceleration)    
    {
        super(x, y, width, height, velocity, acceleration);
    }

// not final, wrong stuff
    public void fall()
    {
        this.y = this.y0 + this.velocity0 + (this.acceleration) / 2;
    }
}
