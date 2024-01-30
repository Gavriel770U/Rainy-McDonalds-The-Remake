public class FallingObject extends BaseObject
{
    public FallingObject(final int x, final int y, final int width, final int height, final double velocity, final double acceleration, final String fallingObjectPath)    
    {
        super(x, y, width, height, velocity, acceleration, fallingObjectPath);
    }

    public void fall()
    {
        this.time = System.currentTimeMillis();

        this.time = (this.time - this.time0) / 1000.0;

        this.y = (int)(this.y0 + this.velocity0 * this.time + 0.5 * this.acceleration * this.time * this.time);
    }

    public void setWidth(final int newWidth)
    {
        // FallingObject's width cannot be changed!
    }

    public void setHeight(final int newHeight)
    {
        // FallingObject's height cannot be changed!
    }
}
