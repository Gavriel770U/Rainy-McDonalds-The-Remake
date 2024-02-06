import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListener implements KeyListener 
{
    private Player player;
    private double listenerStartTime;
    private double listenerCurrentTime;
    private byte direction;

    public CustomKeyListener(Player player, double listenerStartTime)
    {
        super();
        this.player = player;
        this.listenerStartTime = listenerStartTime;
        this.direction = 1;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        listenerCurrentTime = System.currentTimeMillis();

        int checkX = this.player.getHitBox().getX();
        int checkW = this.player.getHitBox().getWidth();

        if ('A' == Character.toUpperCase(keyEvent.getKeyChar()))
        {
            this.direction = -1;

            if (checkX < 0)
            {
                return;
            }

            this.player.move((this.listenerCurrentTime - this.listenerStartTime) / 1000.0, this.direction);
        }
        else if ('D' == Character.toUpperCase(keyEvent.getKeyChar()))
        {
            this.direction = 1;

            if (checkX + checkW >= Settings.FRAME_WIDTH.value)
            {
                return;
            }

            this.player.move((this.listenerCurrentTime - this.listenerStartTime) / 1000.0, this.direction);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {
        if ('W' == Character.toUpperCase(keyEvent.getKeyChar()))
        {
            this.player.setJumping(true);
            this.player.jump();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
        // TODO Auto-generated method stub
    }

}