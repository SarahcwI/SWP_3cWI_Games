package at.sarah.games.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor {
    private float x;
    private float y;
    private float speed;
    public enum Direction {RIGHT, LEFT}
    private Direction direction;


    public Rectangle(Direction direction) {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(800);
        this.speed = 8;
        this.direction = direction;

    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10, 10);
    }

    public void update(int delta) {
        if (this.direction == Direction.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 1000) {
                this.x = 0;
            }
        }

        if (this.direction == Direction.LEFT) {
            this.x -= (float) delta / this.speed;
            if (this.x < 0) {
                this.x = 1000;
            }

        }

    }
}
