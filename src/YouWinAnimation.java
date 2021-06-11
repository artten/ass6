/**
 * @author 319339198
 */

import biuoop.DrawSurface;

/**
 * YouWinAnimation.
 */

public class YouWinAnimation implements Animation {
    private int score;
    private boolean shouldStop = false;

    /**
     * what to do each frame.
     * @param d - surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        String finalWord = "You Win! Your score is " + this.score;
        d.drawText(100, d.getHeight() / 2, finalWord, 32);
    }

    /**
     * set a new score.
     * @param points - the score to set.
     */
    public void setScore(int points) {
        this.score = points;
    }

    /**
     * when it should stop.
     * @return true if should stop
     */
    @Override
    public boolean shouldStop() {
        return shouldStop;
    }
}
