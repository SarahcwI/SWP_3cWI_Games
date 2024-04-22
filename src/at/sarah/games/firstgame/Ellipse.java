package at.sarah.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor{
    private float x,y;
    private float speed;

    public Ellipse() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(800);
        this.speed = 8;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 20,40);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        this.y += (float)delta/this.speed;
        this.x += (float)delta/this.speed;

        if(this.x > 800 || this.y > 800){
            this.x = random.nextInt(400);
            this.y = random.nextInt(400);
        }
    }
}
