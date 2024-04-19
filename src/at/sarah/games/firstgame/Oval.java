package at.sarah.games.firstgame;

import org.newdawn.slick.Graphics;

public class Oval {
    private enum DIRECTION {RIGHT, UP, DOWN, LEFT};
    private float x;
    private float y;
    private float speed;


    public Oval(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics){
        graphics.drawOval(this.x,this.y,50, 30);
    }


    public void update (int delta){
        this.x += (float)delta/this.speed;
        if(this.x > 500){
            this.x = 0;
        }
    }

}
