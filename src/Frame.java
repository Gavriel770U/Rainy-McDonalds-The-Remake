import javax.swing.JFrame;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

public class Frame extends JFrame
{
    public Frame (final String backgroundPath,
                  Player player,
                  ArrayList<FallingObject> fallingObjects
    )
    {
        setTitle("Rainy McDonald's The Remake");
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setFocusable(true);
        setResizable(false);
        addKeyListener(new CustomKeyListener(player, System.currentTimeMillis()));

        try
        {
            add
            (
                new Panel (
                   backgroundPath,
                   player,
                   fallingObjects
                )
            );
        }
        catch (IOException ioe)
        {
            System.err.println(ioe);
            System.err.println("Failed to load background image");
        }

        pack();
        setVisible(true);
    }    
}
