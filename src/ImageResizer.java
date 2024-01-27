import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

// Singleton for resizing BufferedImage Objects

public class ImageResizer
{
    private static ImageResizer instance = null;

    private ImageResizer()
    {

    }

    public static synchronized ImageResizer getInstance()
    {
        if (null == instance)
        {
            instance = new ImageResizer();
        }

        return instance;
    }

    public BufferedImage resizeImage(BufferedImage inputImage, final int newWidth, final int newHeight)
    {
        BufferedImage resizedImage = new BufferedImage (
            newWidth,
            newHeight,
            inputImage.getType()
        );

        Graphics2D graphics2D = resizedImage.createGraphics();

        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2D.drawImage (
            inputImage, 
            0, 
            0, 
            newWidth, 
            newHeight,
            null
        );

        graphics2D.dispose();

        return resizedImage;
    }
}
