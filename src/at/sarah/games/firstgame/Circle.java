package at.sarah.games.firstgame;

import org.newdawn.slick.Graphics;

public class Circle {
    private enum DIRECTION {RIGHT, DOWN, LEFT, UP};
    private float x;
    private float y;
    private float speed;

    public Circle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics){
        graphics.drawOval(this.x, this.y,50,50);
    }

    public void update(int delta){
        this.y += (float)delta/this.speed;
        if(this.y > 800){
            this.y = 0;
        }
    }
}
