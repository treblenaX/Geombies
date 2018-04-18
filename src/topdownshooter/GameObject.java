
package topdownshooter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class GameObject {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected int speed;
    protected double direction;
    
    protected Color color1;
    protected Color color2;
    
    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillOval(x, y, w, h);
        
        g.setStroke(new BasicStroke(2));
        g.setColor(color2);
        g.drawOval(x, y, w, h);
    }
}
