/**
 * @author 319339198
 */
/**
 * HitListener.
 */
public interface HitListener {
    /**
     * his method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit - the block
     * @param hitter - the ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}