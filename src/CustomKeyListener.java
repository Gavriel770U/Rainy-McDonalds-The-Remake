import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListener implements KeyListener 
{
    private Player player;
    private double listenerStartTime;
    private double listenerCurrentTime;

    public CustomKeyListener(Player player, double listenerStartTime)
    {
        super();
        this.player = player;
        this.listenerStartTime = listenerStartTime;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        listenerCurrentTime = System.currentTimeMillis();

        int checkX = this.player.getHitBox().getX();
        int checkW = this.player.getHitBox().getWidth();

        if (keyEvent.getKeyChar() == 'a' || keyEvent.getKeyChar() == 'A')
        {
            if (checkX < 0)
            {
                return;
            }

            this.player.move((this.listenerCurrentTime - this.listenerStartTime) / 1000.0, (byte)(-1));
        }
        else if (keyEvent.getKeyChar() == 'd' || keyEvent.getKeyChar() == 'D')
        {
            if (checkX + checkW >= Settings.FRAME_WIDTH.value)
            {
                return;
            }

            this.player.move((this.listenerCurrentTime - this.listenerStartTime) / 1000.0, (byte)(1));
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {
        // TODO Auto-generated method stub  
    }

    @Override
    public void keyTyped(KeyEvent keyEvent)
    {
        // TODO Auto-generated method stub
    }

}