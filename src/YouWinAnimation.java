/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * YouWinAnimation.
 */

public class YouWinAnimation implements Animation{
    private int score;
    private boolean shouldStop = false;

    @Override
    public void doOneFrame(DrawSurface d) {
        String finalWord = "You Win! Your score is " + score;
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
