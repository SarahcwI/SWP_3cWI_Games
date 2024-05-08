package at.sarah.games.snowworld;

import org.newdawn.slick.Graphics;

import java.util.Random;


public class Snowflake implements Actor {
    private float x,y;
    private float speed;
    private float diamter;
    public enum Size {small, medium, large}
    private Size size;

    public Snowflake(Size size) {
        Random random = new Random();
        this.x = random.nextInt(Snowworld.SCREEN_WIDTH);
        this.y = random.nextInt(Snowworld.SCREEN_HEIGHT) - Snowworld.SCREEN_HEIGHT ;
        this.size = size;

        if (this.size == Size.small){
            this.diamter = 5;
            this.speed = 8;
        }
        if (this.size == Size.medium){
            this.diamter = 10;
            this.speed = 4;
        }
        if (this.size == Size.large){
            this.diamter = 15;
            this.speed = 2;
        }
    }


    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.diamter, this.diamter);

    }


    public void update(int delta) {
        Random random = new Random();

        this.y += (float)delta/this.speed;

        if(this.y > Snowworld.SCREEN_HEIGHT){
            this.x = random.nextInt(Snowworld.SCREEN_WIDTH);
            this.y = random.nextInt(Snowworld.SCREEN_HEIGHT) - Snowworld.SCREEN_HEIGHT ;
        }
    }
}
