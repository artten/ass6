/**
 * @author 319339198
 */

import biuoop.DrawSurface;

/**
 * the Animation.
 */
public interface Animation {
    /**
     * drw frame.
     * @param d - surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * check if should stop being displayed.
     * @return - true if should be stopped
     */
    boolean shouldStop();
}
