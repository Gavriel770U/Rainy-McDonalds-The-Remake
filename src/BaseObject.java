import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    protected BufferedImage image;
    protected ImageResizer imageResizer;
    
    public BaseObject(final int x, final int y, final int width, final int height, final double velocity, final double acceleration, final String path)
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
        this.imageResizer = this.imageResizer.getInstance();

        try
        {
            this.image = ImageIO.read(new File(path));

            this.image = this.imageResizer.resizeImage (
                this.image,
                width,
                height
            );
        }
        catch (IOException ioe)
        {
            System.out.println("Failed to open image");
            System.out.println(ioe);
        }
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

    public BufferedImage getImage()
    {
        return this.image;
    }
}
