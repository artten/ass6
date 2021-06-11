/**
 * @author 319339198
 */
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * collidable.
 */
public class Sun implements  Sprite {
    private int sunRadius = 50;
    private int addSub = 1;

    /**
     * what to draw.
     * @param d - surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillCircle(20, 40, sunRadius);
        d.setColor(Color.blue);
        d.fillCircle(d.getWidth() - 20, 40, sunRadius);
    }

    /**
     * what to do each time passed.
     */
    @Override
    public void timePassed() {
        if (sunRadius > 50 && sunRadius < 150) {
            sunRadius = sunRadius + addSub;
        }
        if (sunRadius == 50) {
            sunRadius = sunRadius + 1;
            addSub = 1;
        }

        if (sunRadius == 150) {
            sunRadius = sunRadius - 1;
            addSub = -1;
        }
    }

    /**
     * add to the game component.
     * @param game - the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
