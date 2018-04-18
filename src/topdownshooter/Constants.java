
package topdownshooter;

import java.awt.Color;

/**
 * Constants file for TopDownShooter.java
 * @author elber
 */
public class Constants {
    //Screen properties
    public static final int SCREEN_WIDTH = 1600;
    public static final int SCREEN_HEIGHT = 900;
    public static final Color BACKGROUND_COLOR = Color.lightGray;
    //Player properties
    public static final int PLAYER_WIDTH = 28;
    public static final int PLAYER_HEIGHT = 28;
    public static final int PLAYER_X = (SCREEN_WIDTH / 2) - (PLAYER_WIDTH / 2);
    public static final int PLAYER_Y = (SCREEN_HEIGHT / 2) - (PLAYER_HEIGHT / 2);
    public static final int PLAYER_SPEED = 2;
    public static final Color PLAYER_COLOR = Color.WHITE;
    public static final Color PLAYER_OUTLINE_COLOR = Color.BLACK;
    //Bullet properties
    public static final int BULLET_WIDTH = 5;
    public static final int BULLET_HEIGHT = 10;
    public static final int BULLET_SPEED = 20;
    public static final double BULLET_DELAY = 50;
    public static final Color BULLET_COLOR = Color.YELLOW;
    public static final Color BULLET_OUTLINE_COLOR = Color.BLACK;
}