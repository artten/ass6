/**
 * @author 319339198
 */
import biuoop.DrawSurface;

import java.awt.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * collidable.
 */
public class Flower implements Sprite {
    private static List<Color> colors = new LinkedList<Color>();
    int framePassed = 0;

    public Flower() {
        for (int i = 0; i < 8; i++) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            colors.add(randomColor);
        }

    }
    @Override
    public void drawOn(DrawSurface d) {
        if (framePassed == 90) {
            framePassed = 0;
            Color color = colors.get(0);
            colors.remove(0);
            colors.add(color);
        }
        int startX = d.getWidth() / 2;
        int startY = d.getHeight()/ 2 - 70;
        int radius = 60;
        int radiusChange = 40;
        d.setColor(Color.green);
        d.fillRectangle(startX - 5, startY, 20, startY + 100);
        d.fillOval(startX, startY + 100, 200, 50);
        d.fillOval(startX - 200 , startY + 100, 200, 50);
        d.setColor(Color.blue);
        d.setColor(colors.get(0));
        d.fillCircle(startX, startY - radius, radius / 2);
        d.setColor(colors.get(1));
        d.fillCircle(startX + radiusChange, startY - radiusChange, radius / 2);
        d.setColor(colors.get(2));
        d.fillCircle(startX + radius, startY, radius / 2);
        d.setColor(colors.get(3));
        d.fillCircle(startX + radiusChange, startY + radiusChange, radius / 2);
        d.setColor(colors.get(4));
        d.fillCircle(startX , startY + radius, radius / 2);
        d.setColor(colors.get(5));
        d.fillCircle(startX - radiusChange, startY + radiusChange, radius / 2);
        d.setColor(colors.get(6));
        d.fillCircle(startX - radius, startY, radius / 2);
        d.setColor(colors.get(7));
        d.fillCircle(startX - radiusChange, startY - radiusChange, radius / 2);

        d.setColor(Color.yellow);
        d.fillCircle(startX, startY, radius);
        framePassed++;
    }

    @Override
    public void timePassed() {
    }

    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
