/**
 * @author 319339198
 */
import biuoop.DrawSurface;

import java.awt.*;

/**
 * collidable.
 */
public class Sun implements  Sprite {
    int sunRadius = 50;
    int addSub = 1;
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.yellow);
        d.fillCircle(20, 40, sunRadius);
        d.setColor(Color.blue);
        d.fillCircle(d.getWidth() - 20, 40, sunRadius);
    }

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

    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
