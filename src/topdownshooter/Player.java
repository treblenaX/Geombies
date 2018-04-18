
package topdownshooter;

import java.awt.Graphics2D;
import static topdownshooter.Constants.*;
/**
 *
 * @author elber
 */
public class Player extends GameObject {
    //Fields
    private int dx;
    private int dy;
    
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private boolean fire;
    
    //Constructors    
    public Player()
    {
        dx = 0;
        dy = 0;
        
        x = PLAYER_X;
        y = PLAYER_Y;
        w = PLAYER_WIDTH;
        h = PLAYER_HEIGHT;
        speed = PLAYER_SPEED;
        direction = 0;
        
        color1 = PLAYER_COLOR;
        color2 = PLAYER_OUTLINE_COLOR;
        
        left = false;
        right = false;
        up = false;
        down = false;
        
        fire = false;
    }
    
    //Functions    
    public void setLeft(boolean b)
    {
        left = b;
    }
    
    public void setRight(boolean b)
    {
        right = b;
    }
    
    public void setUp(boolean b)
    {
        up = b;
    }
    
    public void setDown(boolean b)
    {
        down = b;
    }
    
    public void setFire(boolean b)
    {
        fire = b;
    }
    
    public boolean getFire()
    {
        return fire;
    }
    
    public void update()
    {
        if (left)
        {
            dx = -speed;
            direction = 180;
        }
        if (right)
        {
            dx = speed;
            direction = 0;
        }
        if (up)
        {
            dy = -speed;
            direction = 90;
        }
        if (down)
        {
            dy = speed;
            direction = 270;
        }
        x += dx;
        y += dy;
            
        if (dy < 0 && dx < 0) {direction = 135;} 
        if (dy < 0 && dx > 0) {direction = 45;}
        if (dy > 0 && dx < 0) {direction = 225;}
        if (dy > 0 && dx > 0) {direction = 315;}
        
        dx = 0;
        dy = 0;

    }
    
    @Override
    public void draw(Graphics2D g)
    {   
        super.draw(g);
    }
}
