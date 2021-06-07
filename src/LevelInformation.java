/**
 * @author 319339198
 */

import java.util.List;

/**
 * Level info.
 */
public interface LevelInformation {

    /**
     * number of balls.
     * @return number of balls
     */
    int numberOfBalls();

    /**
     * add velocities.
     * @return list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddle speed.
     * @return paddle speed
     */
    int paddleSpeed();

    /**
     * paddle width.
     * @return paddle width
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     * level name.
     * @return name
     */
    String levelName();
    // Returns a sprite with the background of the level
    /**
     *  background.
     * @return background
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    /**
     * create blocks.
     * @return list of the blocks
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    /**
     * num of block
     * @return - num of bloks
     */
    int numberOfBlocksToRemove();
}