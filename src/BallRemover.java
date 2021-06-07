/**
 * @author 319339198
 */
/**
 * ball Remover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter counter;

    /**
     * Constructor.
     * @param game - the game
     * @param counter -  balls counter
     */
    public BallRemover(GameLevel game, Counter counter) {
        this.game = game;
        this.counter = counter;
    }

    /**
     * increse the numbers of balls.
     * @param num - the num ber to increase
     */
    public void addBall(int num) {
        counter.increase(num);
    }

    /**
     * Blocks that are hit should be removed.
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     * @param beingHit - the block that was hit
     * @param hitter - the ball that hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.counter.decrease(1);
        this.game.removeSprite(hitter);
    }

    /**
     * get the number of remained balls.
     * @return int num of balls
     */
    public int remainedBalls() {
        return counter.getValue();
    }
}
