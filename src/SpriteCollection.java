/**
 * @author 319339198
 */

import biuoop.DrawSurface;

import java.util.LinkedList;

/**
 * collection of Sprites.
 */
public class SpriteCollection {
    private LinkedList<Sprite> allSprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.allSprites = new LinkedList<>();
    }

    /**
     * add Sprite.
     * @param s - a new Sprite to add
     */
    public void addSprite(Sprite s) {
        this.allSprites.add(s);
    }

    /**
     * remove Sprite.
     * @param s - a new Sprite to add
     */
    public void removeSprite(Sprite s) {
        this.allSprites.remove(s);
    }

    /**
     *  call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (Sprite s : allSprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d - the surface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : allSprites) {
            s.drawOn(d);
        }
    }
}