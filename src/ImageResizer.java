
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
}
