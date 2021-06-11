/**
 * @author 319339198
 */
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * Disco.
 */
public class Disco implements Sprite {
    private int sunRadius = 50;
    private int addSub = 1;
    private int framesPassed = 0;
    private Color[] colors = new Color[64];
    @Override


    /**
     * what to draw.
     * @param d - surface
     */
    public void drawOn(DrawSurface d) {
        if (framesPassed == 0) {
            for (int i = 0; i < 8; i++) {
                int numOfBlocks = 8;
                for (int j = 0; j < numOfBlocks; j++) {
                    Random rand = new Random();
                    float r = rand.nextFloat();
                    float g = rand.nextFloat();
                    float b = rand.nextFloat();
                    Color randomColor = new Color(r, g, b);
                    colors[i * 8 + j] = randomColor;
                    d.setColor(randomColor);
                    d.fillRectangle(j * 100, 75 * i, 100, 75);
                    d.setColor(Color.BLACK);
                    d.drawRectangle(j * 100, 75 * i, 100, 75);
                }
            }
            framesPassed++;
        } else {
            for (int i = 0; i < 8; i++) {
                int numOfBlocks = 8;
                for (int j = 0; j < numOfBlocks; j++) {
                    d.setColor(colors[i * 8 + j]);
                    d.fillRectangle(j * 100, 75 * i, 100, 75);
                    d.setColor(Color.BLACK);
                    d.drawRectangle(j * 100, 75 * i, 100, 75);
                }
            }
            framesPassed++;
            if (framesPassed == 60) {
                framesPassed = 0;
            }
        }
    }

    /**
     * what to do each time.
     */
    @Override
    public void timePassed() {
    }

    /**
     * add to the game.
     * @param game - the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
