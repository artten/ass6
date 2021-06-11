/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean shouldStop = false;
    private boolean isPressed = true;

    /**
     * Constructor.
     * @param sensor - keyboard sensor
     * @param key - key
     * @param animation - where to run
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.key = key;
        this.sensor = sensor;
        this.animation = animation;
    }

    /**
     * what to do each frame.
     * @param d - surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (sensor.isPressed(key)) {
            this.isPressed = false;
            this.shouldStop = true;
        }
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