/**
 * @author 319339198
 */

/**
 * print Listener.
 */

public class PrintingHitListener implements HitListener {
    /**
     * prints when hits.
     * @param beingHit - the block
     * @param hitter - the ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}