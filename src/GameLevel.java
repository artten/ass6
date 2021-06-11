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
public class GameLevel implements Animation{
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private KeyboardSensor keyboard;
    private GUI gui;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener scoreTrackingListener;
    private AnimationRunner runner;
    private boolean running;
    private final int framesPerSecond = 60;
    private LevelInformation levelInformation;
    private Counter counter;
    private int level;


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
    public GameLevel(LevelInformation levelInformation, KeyboardSensor key, AnimationRunner animationRunner,
                     Counter counter, int level) {
        this.level = level;
        this.counter = counter;
        this.levelInformation = levelInformation;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        this.keyboard = key;
        this.runner = animationRunner;
    }

    /**
     * initialize the game the balls for the game.
     * @param startPoint - the start point of the paddle
     * @param width - with of the paddle
     */
    public void initializeBalls(Point startPoint, int width) {
        for (Velocity velocity : this.levelInformation.initialBallVelocities()) {
            Random rn = new Random();
            int startWidth = rn.nextInt(width) + 1;
            Point newPoint = new Point((int) startPoint.getX() + startWidth, (int) startPoint.getY());
            Ball ball =  new Ball(newPoint , 5, Color.BLACK, this.environment);
            ball.setVelocity(velocity);
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
        sprites.addSprite(this.levelInformation.getBackground());
        Color color = Color.red;
        int paddleStartX = WIDTH/2 -levelInformation.paddleWidth()/2;
        Block paddleBlock = new Block(new Rectangle(new Point(paddleStartX, 560), levelInformation.paddleWidth(), 10), color);
        Paddle paddle = new Paddle(this.keyboard, paddleBlock);
        paddle.addToGame(this);
        Counter counter =  this.counter;
        scoreTrackingListener = new ScoreTrackingListener(this, counter);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this, counter);
        scoreIndicator.addToGame();
        color = Color.blue;
        //initializeBlocks(6, 50, 20, 20);
        initializeBalls(new Point(paddleStartX, 440), levelInformation.paddleWidth());
        blockRemover = new BlockRemover(this, new Counter());
        ballRemover = new BallRemover(this, new Counter());
        ballRemover.addBall(levelInformation.numberOfBalls());
        initializeBorder(20, Color.GRAY);
        for (Block block : levelInformation.blocks()) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            blockRemover.addedBlock(1);
            block.addToGame(this);
        }
    }

    /**
     * run the game.
     */
    public void run() {
        this.running = true;
        //this.runner = new AnimationRunner(gui, framesPerSecond);
        int numOfSeconds = 3;
        int countFrom = 3;
        runner.setFramesPerSecond(numOfSeconds/countFrom);
        this.runner.run(new CountdownAnimation(numOfSeconds,countFrom, sprites));
        runner.setFramesPerSecond(framesPerSecond);
        this.runner.run(this);
        //gui.close();
    }

    /**
     * Draw one frame.
     * @param d - the surface
     */
    public void doOneFrame(DrawSurface d){
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            //this.runner.run(new PauseScreen(this.keyboard));
            KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboard));
            this.runner.run(keyPressStoppableAnimation);
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
     * @return - if the game should stop
     */
    public boolean shouldStop(){
        return !this.running;
    }

    public int getNumBalls () {
        return ballRemover.remainedBalls();
    }

    public int getNumBlocks() {
        return  blockRemover.remainedBlocks();
    }

    public String getLevelName() {
        return levelInformation.levelName();
    }

    public int getLevelNumber() {
        return this.level;
    }
}