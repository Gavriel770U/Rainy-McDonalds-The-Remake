import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Panel extends JPanel
{
    private ImageResizer imageResizer;
    private BufferedImage backgroundImage;
    private double startTime;
    private double currentTime;
    private Player player;
    private ArrayList<FallingObject> fallingObjects;

    public Panel (final String backgroundPath,
                  Player player,
                  ArrayList<FallingObject> fallingObjects
    ) throws IOException
    {
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
        setVisible(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);

        this.imageResizer = ImageResizer.getInstance();

        this.backgroundImage = ImageIO.read(new File(backgroundPath));

        this.backgroundImage = this.imageResizer.resizeImage (
            this.backgroundImage,
            Settings.FRAME_WIDTH.value,
            Settings.FRAME_HEIGHT.value
        );

        this.player = player;

        this.fallingObjects = fallingObjects;
        
        this.startTime = System.currentTimeMillis();
    }    

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        
        graphics.drawImage(this.backgroundImage, 0, 0, this);

        this.currentTime = (System.currentTimeMillis() - this.startTime) / 1000.0;

        graphics.drawImage(this.player.getImage(), this.player.getX(), this.player.getY(), this);

        Iterator<FallingObject> iter = this.fallingObjects.iterator();

        while (iter.hasNext())
        {
            FallingObject fallingObject = iter.next();

            graphics.drawImage(fallingObject.getImage(), fallingObject.getX(), fallingObject.getY(), this);

            fallingObject.fall(this.currentTime);

            if (this.player.isColliding(fallingObject))
            {
                iter.remove();

                // this.player.setHeight(this.player.getHeight() + 100);
                // this.player.setWidth(this.player.getWidth() + 100);
            }
        }

        repaint();
    }
}
