/**
 * @author 319339198
 */

/**
 * Block Remover.
 */
public class BlockRemover implements HitListener {
    private Game game;
    private Counter remainingBlocks;

    /**
     * constructor.
     * @param game - the game
     * @param  remainingBlocks - the blocks that remains
     */
    public BlockRemover(Game game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks =  remainingBlocks;
    }

    /**
     * add number of blocks.
     * @param num - the number to add
     */
    public void addedBlock(int num) {
        remainingBlocks.increase(num);
    }

    /**
     * Blocks that are hit should be removed.
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     * @param beingHit - the block that was hit
     * @param hitter - the ball that hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(beingHit.getHitListener().get(0));
        this.game.removeSprite(beingHit);
        this.game.removeCollidable(beingHit);
    }

    /**
     * get the number of remained blocks.
     * @return int num of blocks
     */
    public int remainedBlocks() {
        return remainingBlocks.getValue();
    }
}