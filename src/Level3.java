/**
 * @author 319339198
 */

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Level 3.
 */
public class Level3 implements LevelInformation {


    /**
     * number of balls.
     * @return number of balls
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }

    /**
     * add velocities.
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
        return 5;
    }

    /**
     * paddle width.
     * @return paddle width
     */
    @Override
    public int paddleWidth() {
        return 75;
    }

    /**
     * level name.
     * @return name
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     *  background.
     * @return background
     */
    @Override
    public Sprite getBackground() {
        return new Disco();
    }

    /**
     * create blocks.
     * @return list of the blocks
     */
    @Override
    public List<Block> blocks() {
        int width = 50;
        int height = 20;
        int shift = 70;
        List<Block> blocks = new LinkedList<Block>();
        Block block;
        for (int i = 0; i < 6; i++) {
            Random rand = new Random();
            int numOfBlocks = 12;
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            for (int j = 0; j < numOfBlocks - i; j++) {
                block = new Block(new Rectangle(new Point(800 - (shift + j * width),
                        shift + (height * (i + 1)) + height * 5), width, height), randomColor);
                blocks.add(block);
            }
        }
        return blocks;
    }

    /**
     * num of block.
     * @return - num of bloks
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 57;
    }
}
