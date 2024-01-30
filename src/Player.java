import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

    public void setWidth(final int newWidth)
    {
        this.width = newWidth;
        
        this.image = this.imageResizer.resizeImage (
                     this.image,
                     this.width,
                     this.height
        );
    }

    public void setHeight(final int newHeight)
    {
        this.height = newHeight;
        
        this.image = this.imageResizer.resizeImage (
                     this.image,
                     this.width,
                     this.height
        );
    }
}