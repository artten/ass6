/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * the  count down Animation.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop = false;
    private GUI gui;
    private AnimationRunner runner;
    private int numberToDisplay;

    /**
     * constructor.
     * @param numOfSeconds - number of seconds that will be played
     * @param countFrom - count from
     * @param gameScreen - all the sprite of the game
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom + 1;
        this.numOfSeconds = numOfSeconds + 1;
        this.gameScreen = gameScreen;
        this.numberToDisplay = countFrom;
    }

    /**
     * what to display every second.
     * @param d - surface
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, Integer.toString(this.numberToDisplay), 32);
        this.numberToDisplay = this.numberToDisplay - 1;
        if (this.numberToDisplay == 0) {
            this.stop = true;
            return;
        }
    }

    /**
     * should the runner stop to display that image.
     * @return - true if needed to be stopped
     */
    public boolean shouldStop() {
        return this.stop;
    }
}