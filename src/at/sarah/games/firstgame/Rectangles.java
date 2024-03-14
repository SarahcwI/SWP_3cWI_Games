package at.sarah.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;

public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private float speed;
    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100;
        this.y = 100;
        this.speed = 2.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {


        if (this.x <= 800 && this.y <= 100){
            System.out.println("x" + this.x + "y" + this.y);
            System.out.println("goint right");
            moveRight(delta);
        }

        if (this.x >= 800 && this.y < 600){
            moveDown(delta);
            System.out.println("x" + this.x + "y" + this.y);
            System.out.println("going down");
        }

        else if (this.x > 100 && this.y >= 600){
            moveLeft(delta);
            System.out.println("x" + this.x + "y" + this.y);
            System.out.println("going right");
        }

        else if (this.x <= 100 && this.y >= 100){
            System.out.println("x" + this.x + "y" + this.y);
            moveUp(delta);
        }







    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x,this.y,100,100);
        graphics.drawString("Hello World!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(1000,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    public void moveRight(int delta){
        this.x += (float)delta/this.speed;
    }

    public void moveLeft(int delta){
        this.x -= (float)delta/this.speed;
    }

    public void moveUp(int delta){
        this.y -= (float)delta/this.speed;
    }

    public void moveDown(int delta){
        this.y += (float)delta/this.speed;
    }
}
