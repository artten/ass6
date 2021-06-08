/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * YouLooseAnimation.
 */

public class YouLooseAnimation implements Animation{
    private int score;
    private boolean shouldStop = false;

    @Override
    public void doOneFrame(DrawSurface d) {
        String finalWord = "Game Over. Your score is " + score;
        d.drawText(100, d.getHeight() / 2, finalWord, 32);
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean shouldStop() {
        return shouldStop;
    }
}
