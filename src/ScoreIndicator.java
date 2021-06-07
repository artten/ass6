/**
 * @author 319339198
 */

import biuoop.DrawSurface;

import java.awt.*;

/**
 * display score.
 */
public class ScoreIndicator implements Sprite {
    private GameLevel game;
    private Counter counter;

    /**
     * Constructor.
     * @param game - this game
     * @param counter - this counter
     */
    public ScoreIndicator(GameLevel game, Counter counter) {
        this.game = game;
        this.counter = counter;
    }

    /**
     * draw the Score.
     * @param d - surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        String levelNum = "Level: " + this.game.getLevelNumber();
        d.fillRectangle(0, 0, d.getWidth(), 20);
        d.setColor(Color.BLACK);
        d.drawText(d.getWidth() / 2, 14, Integer.toString(counter.getValue()), 15);
        d.drawText(50, 14, levelNum, 15);
        d.drawText(d.getWidth() - 100, 14, this.game.getLevelName(), 15);
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
