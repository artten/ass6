/**
 * @author 319339198
 */

import biuoop.DrawSurface;

/**
 * YouLooseAnimation.
 */

public class YouLooseAnimation implements Animation {
    private int score;
    private boolean shouldStop = false;

    /**
     * what to do each frame.
     * @param d - surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        String finalWord = "Game Over. Your score is " + score;
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
