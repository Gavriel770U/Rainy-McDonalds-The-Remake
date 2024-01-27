import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel
{
    private BufferedImage backgroundImage;

    public Panel(final String backgroundPath) throws IOException
    {
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
        setVisible(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        this.backgroundImage = ImageIO.read(new File(backgroundPath));
        this.backgroundImage = new BufferedImage (
            Settings.FRAME_WIDTH.value,
            Settings.FRAME_HEIGHT.value,
            backgroundImage.getType()
        );
    }    

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        
        graphics.drawImage(this.backgroundImage, 0, 0, this);
    }
}
