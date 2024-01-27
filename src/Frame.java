import javax.swing.JFrame;
import java.awt.Dimension;

public class Frame extends JFrame
{
    public Frame()
    {
        setTitle("Rainy McDonald's The Remake");
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setFocusable(true);
        setResizable(false);
        add(new Panel());
        pack();
        setVisible(true);
    }    
}
