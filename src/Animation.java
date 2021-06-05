/**
 * @author 319339198
 */

import biuoop.DrawSurface;

/**
 * the Animation.
 */
public interface Animation {
    void doOneFrame(DrawSurface d);
    boolean shouldStop();
}
