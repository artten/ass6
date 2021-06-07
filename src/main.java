/**
 * @author 319339198
 */

import biuoop.GUI;

import java.util.LinkedList;
import java.util.List;

/**
 * Level 1.
 */
public class main {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    public static void main(String[] args) {
        GUI gui = new GUI("Really Cool Game", WIDTH, HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        GameFlow gameFlow = new GameFlow(runner, gui);
        List<LevelInformation> levelInformations = new LinkedList<LevelInformation>();
        levelInformations.add(new Level1());
        gameFlow.runLevels(levelInformations);
    }

}
