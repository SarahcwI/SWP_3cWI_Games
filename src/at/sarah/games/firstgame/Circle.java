package at.sarah.games.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle {
    private float x,y;
    private float speed;
    private int diamter;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(800);
        this.speed = random.nextInt(40) + 10;
        this.diamter = random.nextInt(20) + 10;
    }

    public void render(Graphics graphics){
        graphics.drawOval(this.x, this.y,this.diamter,this.diamter);
    }

    public void update(int delta){
        this.y += (float)delta/this.speed;
        if(this.y > 800){
            this.y = 0;
        }
    }
}
