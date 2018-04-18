
package topdownshooter;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static topdownshooter.Constants.*;

/**
 *
 * @author elber
 */
public class TopDownShooter {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Top Down Shooter");
        
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setContentPane(new GamePanel());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);     
        frame.setResizable(false);       
        frame.setFocusable(true);

        frame.setVisible(true);
    }
    
}
