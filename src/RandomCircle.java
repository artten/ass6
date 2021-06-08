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
public class RandomCircle implements Sprite {
    private int sunRadius = 50;
    private int addSub = 1;
    private int framesPassed = 0;
    private List<Color> colors = new LinkedList<Color>();
    private List<Point> circles = new LinkedList<Point>();
    @Override
    public void drawOn(DrawSurface d) {
        if (framesPassed % 15 == 0) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            colors.add(randomColor);
            rand = new Random();
            int x = (int) (Math.random() * (780 - 20)) + 20;
            int y = (int) (Math.random() * (780 - 20)) + 20;
            circles.add(new Point(x, y));
            circles.add(new Point(0, 0));
            framesPassed ++;
        }
        for (int i = 0; i < colors.size(); i++) {
            if (circles.get(i * 2 + 1).getX() > 150) {
                circles.remove(i * 2);
                circles.remove(i * 2 + 1);
                colors.remove(i);
                i--;
            }
            else {
                d.setColor(colors.get(i));
                d.fillCircle( (int) circles.get(i * 2).getX(), (int) circles.get(i * 2).getY(), (int) circles.get(i * 2 + 1).getX());
                circles.add(i * 2 + 2, new Point(circles.get(i * 2 + 1).getX() + 1, 0));
                circles.remove(i * 2 + 1);
            }
        }
        framesPassed ++;
        if (framesPassed == 60) {
            framesPassed = 0;
        }
    }

    @Override
    public void timePassed() {
    }

    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
