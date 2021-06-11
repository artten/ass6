/**
 * @author 319339198
 */

import biuoop.KeyboardSensor;
import biuoop.GUI;
import java.util.List;

/**
 * Game Flow.
 */
public class GameFlow {
    private AnimationRunner ar;
    private  GUI gui;

    /**
     * Constructor.
     * @param ar - animation runner
     * @param gui - the gui to run on
     */
    public GameFlow(AnimationRunner ar, GUI gui) {
        this.ar = ar;
        this.gui = gui;
    }

    /**
     * runs all the levels.
     * @param levels - levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        int i = 0;
        Counter counter = new Counter();
        for (LevelInformation levelInfo : levels) {
            i++;
            GameLevel level = new GameLevel(levelInfo, gui.getKeyboardSensor(), this.ar, counter, i);
            level.initialize();
            while (level.getNumBalls() != 0 && level.getNumBlocks() != 0) {
                level.run();
            }

            if (level.getNumBlocks() != 0) {
                int score = counter.getValue();
                YouLooseAnimation youLooseAnimation = new YouLooseAnimation();
                youLooseAnimation.setScore(score);
                KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(
                        gui.getKeyboardSensor(),
                        KeyboardSensor.SPACE_KEY, youLooseAnimation);
                this.ar.run(keyPressStoppableAnimation);
                gui.close();
            }
        }
        int score = counter.getValue();
        YouWinAnimation youWinAnimation = new YouWinAnimation();
        youWinAnimation.setScore(score);
        KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                KeyboardSensor.SPACE_KEY, youWinAnimation);
        this.ar.run(keyPressStoppableAnimation);
        gui.close();
    }
}