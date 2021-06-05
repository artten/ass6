import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 319339198
 * Blocks of the game
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle block;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new LinkedList<HitListener>();

    /**
     * creates a new Block.
     * @param rectangle - the new block
     */
    public Block(Rectangle rectangle) {
        this.block = rectangle;
    }

    /**
     * creates a new Block.
     * @param rectangle - the new block
     * @param color - the color
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.block = rectangle;
        this.color = color;
    }

    /**
     * creates a new Block.
     * @return this color block
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * return the block.
     * @return this block
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * matrix with the velocity to change.
     * @param collisionPoint - where the collision occurred
     * @return matrix with the velocity to change
     */
    private Point velocityChange(Point collisionPoint) {
        double width = block.getWidth();
        double height = block.getHeight();
        if (collisionPoint.getX() == block.getBottomLeft().getX()
                || collisionPoint.getX() == block.getBottomRight().getX()) {
            return new Point(-1, 1);
        }
        if (collisionPoint.getY() == block.getBottomLeft().getY()
                || collisionPoint.getY() == block.getUpperRight().getY()) {
            return new Point(1, -1);
        }
        return new Point(1, 1);
    }


    /**
     * notify all listener that the ball was hit.
     * @param hitter - the ball that hit the ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * return a new velocity for a ball.
     * @param collisionPoint - where the hit occurred
     * @param currentVelocity - current velocity of the ball
     * @param hitter - the ball that hit the block
     * @return a new velocity for a ball
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point velocityChange = velocityChange(collisionPoint);
        Velocity newVelocity = new Velocity(currentVelocity.getDx() * velocityChange.getX(),
                currentVelocity.getDy() * velocityChange.getY());
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * draw this block on the surface.
     * @param surface - the surface to draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.block.getUpperLeft().getX(),
                (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(),
                (int) this.block.getHeight());
    }

    /**
     * what should the  block do after some time.
     */
    @Override
    public void timePassed() { }

    /**
     * add the ball to the game.
     * @param game - the game object
     */
    public void addToGame(Game game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * Add hl as a listener to hit events.
     * @param hl - listener
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Add hl as a listener to hit events.
     * @return return list with all listeners
     */
    public List<HitListener> getHitListener() {
        return this.hitListeners;
    }

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl - listener
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

}

