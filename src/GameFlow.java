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

    public GameFlow(AnimationRunner ar, GUI gui) {
        this.ar = ar;
        this.gui = gui;
    }

    public void runLevels(List<LevelInformation> levels) {
        int i = 0;
        Counter counter = new Counter();
        for (LevelInformation levelInfo : levels) {
            i++;
            GameLevel level = new GameLevel(levelInfo, gui, this.ar, counter, i);
            level.initialize();
            while (level.getNumBalls() != 0 && level.getNumBlocks() != 0) {
                level.run();
            }

            if (level.getNumBlocks() != 0) {
                break;
            }

        }
    }
}