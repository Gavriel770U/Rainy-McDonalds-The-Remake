import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
        
        BufferedImage resizedImage = new BufferedImage (
            Settings.FRAME_WIDTH.value,
            Settings.FRAME_HEIGHT.value,
            backgroundImage.getType()
        );

        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage (
            this.backgroundImage, 
            0, 
            0, 
            Settings.FRAME_WIDTH.value, 
            Settings.FRAME_HEIGHT.value,
            null
        );
        graphics2D.dispose();
        this.backgroundImage = resizedImage;
    }    

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        
        graphics.drawImage(this.backgroundImage, 0, 0, this);

        repaint();
    }
}
