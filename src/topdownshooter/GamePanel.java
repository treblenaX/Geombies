/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topdownshooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import static topdownshooter.Constants.*;

/**
 *
 * @author elber
 */
public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener {  
    //Fields
    private Thread t;
    private int averageFPS;
    private boolean running;
    private double hertz = 60.0;
    private Player player;
    
    private float startTime;
    
    private double bulletWaitTime;
    
    private ArrayList<Bullet> bullets;
    private boolean fired;
    
    //Constructor
    public GamePanel()
    {
        super();
        
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(BACKGROUND_COLOR);
        setFocusable(true);    
        fired = false;
        bullets = new ArrayList<>();
        bulletWaitTime = 0;
    }
    
    //Functions
    @Override
    public void addNotify()
    {
        super.addNotify();
        if (t == null)
        {
            t = new Thread(this);
            t.start();
        }
        requestFocusInWindow();
        addKeyListener(this);
    }
    
    @Override
    public void run() {
        running = true;
        
        player = new Player();
        
        
        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;
        
        int frameCount = 0;
        int maxFrameCount = 60;
        
        long targetTime = (long) (1000 / hertz); //16 ms per frame
        
        //Game Loop
        while (running)
        {
            startTime = System.nanoTime();
            
            gameUpdate();
            gameRender();
            gameDraw();
            
            URDTimeMillis = (System.nanoTime() - startTime) / 1000000; //Divide by million to get nano to milliseconds
                
            waitTime = targetTime - URDTimeMillis; //Amount of extra time needed to wait
            
            try {
                t.sleep(waitTime); //Sleeps for that extra time until the next frame 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == maxFrameCount)
            {
                averageFPS = (int) (1000.0 / (((double)totalTime / frameCount) / 1000000));
                frameCount = 0;
                totalTime = 0;
            }
        }
    }
    
    //URD Functions
    public void gameUpdate()
    {
        player.update();
        checkFire();
    }
    
    public void gameRender()
    {
        if (fired)
        {
            bullets.add(new Bullet(player));
            
            setFired(false);
        }
    }
    
    public void gameDraw()
    {
        repaint();
    }
    
    //GUI Functions
    public void drawFPSCounter(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawString("FPS: " + (int) averageFPS, 10, 20);
    }
    
    //Bullet and Player Functions
    public void checkFire()
    {
        fired = false;
        if (player.getFire())
        {
            fired = true;
        }
    }
    //Getters and Setters
    public void setFired(boolean b)
    {
        fired = b;
    }
    
    //Overriden Functions
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); 
        drawFPSCounter(g);
        player.draw((Graphics2D) g);
        if (!bullets.isEmpty())
        {
           for (Bullet bullet: bullets)
           {
               bullet.draw((Graphics2D) g);
           }
                
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        //Movement
        if (keyCode == KeyEvent.VK_A)
        {
            player.setLeft(true);
        }
        if (keyCode == KeyEvent.VK_D)
        {
            player.setRight(true);
        }
        if (keyCode == KeyEvent.VK_W)
        {
            player.setUp(true);
        }
        if (keyCode == KeyEvent.VK_S)
        {
            player.setDown(true);
        }
        //Fire
        if (keyCode == KeyEvent.VK_ENTER)
        {
            player.setFire(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        //Movement
        if (keyCode == KeyEvent.VK_A)
        {
            player.setLeft(false);
        }
        if (keyCode == KeyEvent.VK_D)
            
        {
            player.setRight(false);
        }
        if (keyCode == KeyEvent.VK_W)
        {
            player.setUp(false);
        }
        if (keyCode == KeyEvent.VK_S)
        {
            player.setDown(false);
        }
        //Fire
        if (keyCode == KeyEvent.VK_ENTER)
        {
            player.setFire(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}