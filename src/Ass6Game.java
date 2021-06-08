import biuoop.GUI;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 319339198
 */

public class Ass6Game {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;


    public static void main(String[] args) {
        GUI gui = new GUI("Really Cool Game", WIDTH, HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui, 60);
        GameFlow gameFlow = new GameFlow(runner, gui);
        List<LevelInformation> levelInformations = new LinkedList<LevelInformation>();
        for (String string : args) {
            if (string == "1") {
                levelInformations.add(new Level1());
            }
            if (string == "2") {
                levelInformations.add(new Level2());
            }
            if (string == "3") {
                levelInformations.add(new Level3());
            }
            if (string == "4") {
                levelInformations.add(new Level4());
            }
        }
        gameFlow.runLevels(levelInformations);
    }
}
