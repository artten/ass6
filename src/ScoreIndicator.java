/**
 * @author 319339198
 */

import biuoop.DrawSurface;

import java.awt.*;

/**
 * display score.
 */
public class ScoreIndicator implements Sprite {
    private Game game;
    private Counter counter;

    /**
     * Constructor.
     * @param game - this game
     * @param counter - this counter
     */
    public ScoreIndicator(Game game, Counter counter) {
        this.game = game;
        this.counter = counter;
    }

    /**
     * draw the Score.
     * @param d - surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(d.getWidth() / 2, 14, Integer.toString(counter.getValue()), 15);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {

    }

    /**
     * add the ball to the game.
     */
    public void addToGame() {
        this.game.addSprite(this);
    }

}
