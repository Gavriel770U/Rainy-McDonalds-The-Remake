public class Player extends BaseObject
{    
    private HitBox hitBox;

    public Player(final int x, final int y, final int width, final int height, final double velocity, final double acceleration, final String playerPath)
    {
        super(x, y, width, height, velocity, acceleration, playerPath);
        this.hitBox = new HitBox(x + width / 4, y + height / 4, width / 2, height / 2, velocity, acceleration);
    }

    public void move(final double time, final byte direction)
    {
        this.x += direction * this.velocity;
        this.hitBox.setX((int)(this.hitBox.getX() + direction * this.velocity));
    }

    public void setWidth(final int newWidth)
    {
        int growth = newWidth - this.width;

        this.width = newWidth;

        this.image = this.imageResizer.resizeImage (
                     this.image,
                     this.width,
                     this.height
        );

        this.hitBox.setWidth(this.hitBox.getWidth() + growth);
        this.hitBox.setX(this.x + this.width / 4 - Math.abs(growth)); 
    }

    public void setHeight(final int newHeight)
    {
        this.y -= newHeight - this.height;

        this.height = newHeight;

        this.image = this.imageResizer.resizeImage (
                     this.image,
                     this.width,
                     this.height
        );

        int growth = newHeight - this.height;

        this.hitBox.setHeight(this.hitBox.getHeight() + growth);
        this.hitBox.setY(this.y + this.height / 4);
    }

    public HitBox getHitBox()
    {
        return this.hitBox;
    }

    @Override
    public boolean isColliding(BaseObject other)
    {
        return (
            this.hitBox.getX() < other.getX() + other.getWidth() &&
            this.hitBox.getX() + this.hitBox.getWidth() > other.getX() &&
            this.hitBox.getY() < other.getY() + other.getHeight() &&
            this.hitBox.getY() + this.hitBox.getHeight() > other.getY()
        );
    }
}
