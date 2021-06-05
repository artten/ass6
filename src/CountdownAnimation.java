/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

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

    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom + 1;
        this.numOfSeconds = numOfSeconds + 1;
        this.gameScreen = gameScreen;
        this.numberToDisplay = countFrom;
    }


    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        if (this.numberToDisplay == 0) {
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "Go", 32);
            this.stop = true;
            return;
        }
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, Integer.toString(this.numberToDisplay), 32);
        System.out.println(numberToDisplay);
        this.numberToDisplay = this.numberToDisplay - 1;
    }
    public boolean shouldStop() {
        return this.stop;
    }
}