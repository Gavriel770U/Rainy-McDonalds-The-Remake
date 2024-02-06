import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartFrame extends JFrame 
{
    private static StartFrame instance;
    private static boolean started;
    private static ImageResizer imageResizer;
    private static BufferedImage backgroundImage;

    private StartFrame(String backgroundPath, String playButtonPath) throws IOException
    {
        setTitle("Rainy McDonald's The Remake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAutoRequestFocus(true);
        setFocusable(true);
        setResizable(false);

        imageResizer = ImageResizer.getInstance();

        backgroundImage = ImageIO.read(new File(backgroundPath));

        backgroundImage = imageResizer.resizeImage (
                backgroundImage,
                Settings.FRAME_WIDTH.value,
                Settings.FRAME_HEIGHT.value
        );

        add(new JPanel() {
            {
                setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
                setDoubleBuffered(true);
                setVisible(true);
                setFocusable(true);
                setBackground(Color.BLACK);
                setLayout(null);

                add (new JLabel("RAINY MCDONALD'S THE REMAKE") {
                    {
                        this.setBounds(50,
                        50, 
                        100,
                        30);
                    }
                });

                add(new JButton(new ImageIcon(playButtonPath)) {
                    {
                        this.setBounds(
                            (Settings.FRAME_WIDTH.value - 200) / 2,
                            Settings.FRAME_HEIGHT.value / 2 + 100,
                            200,
                            100
                        );  

                        this.addActionListener(new ActionListener() {  
                            public void actionPerformed(ActionEvent actionEvent)
                            {
                                started = true;
                            }
                        });
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.drawImage(backgroundImage, 0, 0, this);
            }
        });
        pack();
        setVisible(true);

        started = false;
    }

    public static synchronized StartFrame getInstance(String backgroundPath, String playButtonPath)
    {
        if (null == instance)
        {
            try
            {
                instance = new StartFrame(backgroundPath, playButtonPath);
            } 
            catch (IOException ioe) 
            {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public synchronized boolean isStarted() 
    {
        return started;
    }
}