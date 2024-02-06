import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EndFrame extends JFrame 
{
    private static EndFrame instance;
    private static boolean exited;
    private static ImageResizer imageResizer;
    private static BufferedImage backgroundImage;

    private EndFrame(String backgroundPath, String exitButtonPath, String endText) throws IOException 
    {
        setTitle("Rainy McDonald's The Remake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
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

        exited = false;

        add(new JPanel() {
            {
                setPreferredSize(new Dimension(Settings.FRAME_WIDTH.value, Settings.FRAME_HEIGHT.value));
                setDoubleBuffered(true);
                setVisible(true);
                setFocusable(true);
                setBackground(Color.BLACK);
                setLayout(null);

                add(new JLabel() {
                    {
                        setText("===================");
                        setForeground(new Color(0xFFFF00));
                        setFont(new Font("Bauhaus 93", Font.BOLD, 50));
                        setBounds(10, 0, Settings.FRAME_WIDTH.value - 20, 100);
                    }
                });

                add(new JLabel() {
                    {
                        setText(endText);
                        setForeground(new Color(0xFFFF00));
                        setFont(new Font("Bauhaus 93", Font.BOLD, 60));
                        setBounds(100, 40, Settings.FRAME_WIDTH.value - 20, 100);
                    }
                });

                add(new JLabel() {
                    {
                        setText("THANKS FOR PLAYING! :)");
                        setForeground(new Color(0xFFFF00));
                        setFont(new Font("Bauhaus 93", Font.BOLD, 40));
                        setBounds(100, 80, Settings.FRAME_WIDTH.value - 20, 100);
                    }
                });

                add(new JLabel() {
                    {
                        setText("===================");
                        setForeground(new Color(0xFFFF00));
                        setFont(new Font("Bauhaus 93", Font.BOLD, 50));
                        setBounds(10, 120, Settings.FRAME_WIDTH.value - 20, 100);
                    }
                });

                add(new JButton(new ImageIcon(exitButtonPath))
                {
                    {
                        setBounds(
                                (Settings.FRAME_WIDTH.value - 200) / 2,
                                Settings.FRAME_HEIGHT.value / 2 + 100,
                                200,
                                100
                        );

                        addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent actionEvent) 
                            {
                                exited = true;
                            }
                        });
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics graphics) 
            {
                super.paintComponent(graphics);
                graphics.drawImage(backgroundImage, 0, 0, this);

                if (exited)
                {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();
                }

                repaint();
            }
        });
        pack();
        setVisible(true);
    }

    public static synchronized EndFrame getInstance(String backgroundPath, String exitButtonPath, String endText) 
    {
        if (null == instance) 
        {
            try 
            {
                instance = new EndFrame(backgroundPath, exitButtonPath, endText);
            }
            catch (IOException ioe) 
            {
                ioe.printStackTrace();
            }
        }

        return instance;
    }

    public synchronized boolean isExited() 
    {
        return exited;
    }
}