/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topdownshooter;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import static topdownshooter.Constants.*;

/**
 *
 * @author elber
 */
public class Bullet extends GameObject {
    //Fields
    
    //Constructor
    public Bullet(Player player)
    {
        x = player.x;
        y = player.y;
        w = BULLET_WIDTH;
        h = BULLET_HEIGHT;
        speed = BULLET_SPEED;
        direction = player.direction;
        
        color1 = BULLET_COLOR;
        color2 = BULLET_OUTLINE_COLOR;    
    }
    //Functions
    public void draw(Graphics2D g)
    {
        g.setColor(color1);
        g.fillRect(x, y, w, h);
        
        g.setStroke(new BasicStroke(1));
        g.setColor(color2);
        g.drawRect(x, y, w, h);
    }
}
