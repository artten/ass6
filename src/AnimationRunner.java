/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * the Animation.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper = new Sleeper();

    /**
     * constructor.
     * @param gui - the gui to display on
     * @param framesPerSecond -  frame per seconds
     */
    public AnimationRunner(GUI gui, int framesPerSecond){
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * set frame per seconds.
     * @param framesPerSecond - frames per second
     */
    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * display animation.
     * @param animation - the animation to display
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}

