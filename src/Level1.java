/**
 * @author 319339198
 */

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Level 1.
 */
public class Level1 implements LevelInformation {


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocity = new LinkedList<Velocity>();
        for (int i  = 0; i < numberOfBalls(); i++) {
            velocity.add(new Velocity(0, -1));
        }
        return velocity;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 50;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sun();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<Block>();
        Color color = Color.black;
        Block block = new Block(new Rectangle(new Point(375, 100), 50, 20), color);
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
