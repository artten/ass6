/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Pause screen.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k - keyboard sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * what to display each frame.
     * @param d - surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * when it should stop.
     * @return true if should be stopped
     */
    public boolean shouldStop() { return this.stop; }
}