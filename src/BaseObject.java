public abstract class BaseObject
{
    protected int x;
    protected int x0;
    protected int y;
    protected int y0;
    protected int width;
    protected int height;
    protected double velocity0;
    protected double velocity;
    protected double acceleration;
    
    public BaseObject(final int x, final int y, final int width, final int height, final double velocity, final double acceleration)
    {
        this.x = x;
        this.x0 = x;
        this.y = y;
        this.y0 = y;
        this.width = width;
        this.height = height;
        this.velocity0 = velocity;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }
}
