import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.sound.sampled.*;

public class Panel extends JPanel
{
    private ImageResizer imageResizer;
    private BufferedImage backgroundImage;
    private Player player;
    private ArrayList<FallingObject> fallingObjects;

    public Panel (final String backgroundPath,
                  Player player,
                  ArrayList<FallingObject> fallingObjects,
                  String backgroundMusicPath
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

        try 
        {
            File audioFile = new File(backgroundMusicPath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            System.out.println(e.getMessage());
        }
    }    

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        
        graphics.drawImage(this.backgroundImage, 0, 0, this);

        graphics.drawImage(this.player.getImage(), this.player.getX(), this.player.getY(), this);

        Iterator<FallingObject> iter = this.fallingObjects.iterator();
        ArrayList<FallingObject> deleted = new ArrayList<FallingObject>();

        while (iter.hasNext())
        {
            FallingObject fallingObject = iter.next();

            graphics.drawImage(fallingObject.getImage(), fallingObject.getX(), fallingObject.getY(), this);

            graphics.setColor(Color.CYAN);
            graphics.drawRect(this.player.getHitBox().getX(), this.player.getHitBox().getY(),this.player.getHitBox().getWidth(), this.player.getHitBox().getHeight());

            fallingObject.fall();

            if (this.player.isColliding(fallingObject) || fallingObject.getY() > Settings.FRAME_HEIGHT.value)
            {
                iter.remove();

                if(this.player.isColliding(fallingObject))
                {
                    this.player.setHeight(this.player.getHeight() + fallingObject.getHeightGrowth());
                    this.player.setWidth(this.player.getWidth() + fallingObject.getWidthGrowth());
                    try
                    {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fallingObject.getSoundPath()).getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();  
                    }      
                    catch (Exception e)
                    {
                        // sounds playing issues
                        System.out.println(e.getMessage());
                    }
                }
                    
                Random rand = new Random();

                deleted.add(new FallingObject 
                (
                    rand.nextInt((Settings.FRAME_WIDTH.value - fallingObject.getWidth() + 1)),
                    (2 * fallingObject.getHeight() + rand.nextInt(250)) * -1,
                    fallingObject.getWidth(),
                    fallingObject.getHeight(),
                    fallingObject.getVelocity(),
                    fallingObject.getAcceleration(),
                    fallingObject.getPath(),
                    fallingObject.getSoundPath(),
                    fallingObject.getWidthGrowth(),
                    fallingObject.getHeightGrowth()
                ));
            }
        }

        iter = deleted.iterator();

        while (iter.hasNext())
        {
            FallingObject fallingObject = iter.next();

            this.fallingObjects.add( new FallingObject
            (
                fallingObject.getX(),
                fallingObject.getY(),
                fallingObject.getWidth(),
                fallingObject.getHeight(),
                fallingObject.getVelocity(),
                fallingObject.getAcceleration(),
                fallingObject.getPath(),
                fallingObject.getSoundPath(),
                fallingObject.getWidthGrowth(),
                fallingObject.getHeightGrowth()
            ));

            iter.remove();
        }

        this.player.jump();

        if (this.player.getWidth() >= Settings.FRAME_WIDTH.value * 3 / 4 && this.player.getHeight() >= Settings.FRAME_HEIGHT.value - this.player.getHeight() * 3 / 4)
        {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
             
            EndFrame.getInstance("./resources/backgrounds/outdoorsbackground.png", "./resources/buttons/exitbutton.png", "CHEERS! YOU WON!!! :D");
        }
        else if (this.player.getWidth() <= 50 && this.player.getHeight() <= 50)
        {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();

            EndFrame.getInstance("./resources/backgrounds/outdoorsbackground.png", "./resources/buttons/exitbutton.png", "YOU LOST! :'(");
        }

        repaint();
    }
}