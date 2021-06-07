/**
 * @author 319339198
 */

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Level 2.
 */
public class Level2 implements LevelInformation {


    /**
     * number of balls.
     * @return number of balls
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * add velocities
     * @return list of velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocity = new LinkedList<Velocity>();
        for (int i  = 0; i < numberOfBalls(); i++) {
            velocity.add(new Velocity(0, -5));
        }
        return velocity;
    }

    /**
     * paddle speed.
     * @return paddle speed
     */
    @Override
    public int paddleSpeed() {
        return 2;
    }

    /**
     * paddle width.
     * @return paddle width
     */
    @Override
    public int paddleWidth() {
        return 500;
    }

    /**
     * level name.
     * @return name
     */
    @Override
    public String levelName() {
        return "Wide Easy";
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

        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            Block block = new Block(new Rectangle(new Point(20 + i * 70, 100), 70, 20), randomColor);
            blocks.add(block);
        }
        return blocks;
    }

    /**
     * num of block.
     * @return - num of bloks
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 8;
    }
}
