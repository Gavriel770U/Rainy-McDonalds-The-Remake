class HitBox extends BaseObject
{
    public HitBox(final int x, final int y, final int width, final int height, final double velocity, final double acceleration)
    {
        super(x, y, width, height, velocity, acceleration, null);
    }

    public void setWidth(final int newWidth)
    {
        this.width = newWidth;
    }

    public void setHeight(final int newHeight)
    {
        this.height = newHeight;
    }
}