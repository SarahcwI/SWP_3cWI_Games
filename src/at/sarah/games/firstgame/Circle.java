package at.sarah.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor {
    private float x,y;
    private float speed;
    private float diamter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(800);
        this.speed = 8;
        this.diamter = random.nextInt(20) + 10;
    }

    public void render(Graphics graphics){
        graphics.drawOval(this.x, this.y,this.diamter,this.diamter);
    }

    public void update(GameContainer gameContainer, int delta){
        Random random = new Random();
        this.y += (float)delta/this.speed;
        this.diamter += 0.01;
        if(this.y > 800){
            this.y = 0;
            this.diamter = random.nextInt(20) + 10;
        }
    }
}
