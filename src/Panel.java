import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class Panel extends JPanel
{
    public Panel()
    {
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
        setVisible(true);
        setBackground(Color.BLACK);
    }    
}
