/**
 * @author 319339198
 */

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 1.
 */
public class Level1 implements LevelInformation {


    /**
     * number of balls.
     * @return number of balls
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * add velocities.
     * @return list of velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocity = new LinkedList<Velocity>();
        for (int i  = 0; i < numberOfBalls(); i++) {
            velocity.add(new Velocity(0, -2));
        }
        return velocity;
    }

    /**
     * paddle speed.
     * @return paddle speed
     */
    @Override
    public int paddleSpeed() {
        return 5;
    }

    /**
     * paddle width.
     * @return paddle width
     */
    @Override
    public int paddleWidth() {
        return 50;
    }

    /**
     * level name.
     * @return name
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     *  background.
     * @return background
     */
    @Override
    public Sprite getBackground() {
        return new Sun();
    }

    /**
     * create blocks.
     * @return list of the blocks
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<Block>();
        Color color = Color.black;
        Block block = new Block(new Rectangle(new Point(375, 100), 50, 20), color);
        blocks.add(block);
        return blocks;
    }

    /**
     * num of block.
     * @return - num of bloks
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
