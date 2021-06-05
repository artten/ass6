/**
 * @author 319339198
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;
import java.util.Random;

/**
 * the Game.
 */
public class Game implements Animation{
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private KeyboardSensor keyboard;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener scoreTrackingListener;
    private AnimationRunner runner;
    private boolean running;
    private final int framesPerSecond = 60;


    /**
     * add a new collidable.
     * @param c - collidable objective
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * remove collidable.
     * @param c - collidable objective
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * add a new sprite.
     * @param s - sprite objective
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * add a new sprite.
     * @param s - sprite objective
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     *
     */
    public Game() {
        this.gui = new GUI("Really Cool Game", WIDTH, HEIGHT);
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        this.keyboard =  gui.getKeyboardSensor();
    }

    /**
     * initialize the game the balls for the game.
     * @param num -number of balls
     * @param startPoint - the start point of the paddle
     * @param width - with of the paddle
     */
    public void initializeBalls(int num, Point startPoint, int width) {
        for (int i = 0; i < num; i++) {
            Random rn = new Random();
            int startWidth = rn.nextInt(width) + 1;
            Point newPoint = new Point((int) startPoint.getX() + startWidth, (int) startPoint.getY());
            Ball ball =  new Ball(newPoint , 5, Color.BLACK, this.environment);
            ball.setVelocity(0, 5);
            ball.addToGame(this);
        }
    }

    /**
     * initialize the the border for the game.
     * @param size - size of the blocks
     * @param color - color fpr the blocks
     */
    public void initializeBorder(int size, Color color) {
        for (int i = 0; i < 4; i++) {
            Block block = new Block(new Rectangle(new Point(0, 15), WIDTH, size), color);
            block.addToGame(this);
            block = new Block(new Rectangle(new Point(0, 15), size, HEIGHT), color);
            block.addToGame(this);
            block = new Block(new Rectangle(new Point(WIDTH - size, 15), size, HEIGHT), color);
            block.addToGame(this);
            block = new Block(new Rectangle(new Point(0, HEIGHT - size), WIDTH, size), color);
            block.addHitListener(ballRemover);
            block.addToGame(this);
        }
    }

    /**
     *
     * @param raws - num of raws
     * @param width - width of a block
     * @param height - height of one block
     * @param shift - shift from the top and left sides
     */
    public void initializeBlocks(int raws, int width, int height, int shift) {
        Block block;
        for (int i = 0; i < raws; i++) {
            Random rand = new Random();
            int numOfBlocks = 12;
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            for (int j = 0; j < numOfBlocks - i; j++) {
                block = new Block(new Rectangle(new Point(WIDTH - (shift + j * width),
                        shift + (height * (i + 1)) + height * 5), width, height), randomColor);
                block.addHitListener(blockRemover);
                block.addHitListener(scoreTrackingListener);
                blockRemover.addedBlock(1);
                block.addToGame(this);
            }
        }
    }

    /**
     * initialize the game.
     */
    public void initialize() {
        Color color = Color.red;
        Block paddleBlock = new Block(new Rectangle(new Point(400, 560), 50, 10), color);
        Paddle paddle = new Paddle(this.keyboard, paddleBlock);
        paddle.addToGame(this);
        Counter counter =  new Counter();
        scoreTrackingListener = new ScoreTrackingListener(this, counter);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this, counter);
        scoreIndicator.addToGame();
        color = Color.blue;
        blockRemover = new BlockRemover(this, new Counter());
        ballRemover = new BallRemover(this, new Counter());
        ballRemover.addBall(2);
        initializeBlocks(6, 50, 20, 20);
        initializeBorder(20, Color.GRAY);
        initializeBalls(2, new Point(400, 440), 50);
    }

    /**
     * run the game.
     */
    public void run() {
        this.running = true;
        this.runner = new AnimationRunner(gui, framesPerSecond);
        int numOfSeconds = 3;
        int countFrom = 3;
        runner.setFramesPerSecond(numOfSeconds/countFrom);
        this.runner.run(new CountdownAnimation(numOfSeconds,countFrom, sprites));
        runner.setFramesPerSecond(framesPerSecond);
        this.runner.run(this);
    }

    /**
     * Draw one frame.
     * @param d - the surface
     */
    public void doOneFrame(DrawSurface d){
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        if (blockRemover.remainedBlocks() == 0) {
            scoreTrackingListener.addScore(100);
            this.running = false;
        }
        if (ballRemover.remainedBalls() == 0) {
            this.running = false;
        }
    }

    /**
     * check if animation should stop
     * @return
     */
    public boolean shouldStop(){
        return !this.running;
    }
}