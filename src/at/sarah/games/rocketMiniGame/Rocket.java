package at.sarah.games.rocketMiniGame;

import at.sarah.games.collision.CollissionActor;
import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;

public class Rocket implements CollissionActor {
    private Image rocketImage;
    private float x,y;
    private float speed;
    private float rot;



    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/turtle.png");
        this.rocketImage = tmp.getScaledCopy(120, 120);
        this.x = 100;
        this.y = 100;
        this.speed = 2;
        this.rot = 90;
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x,this.y);
        rocketImage.setRotation(rot);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        int width = gameContainer.getWidth();
        int height = gameContainer.getHeight();

        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){
            this.x += (float)delta/speed;
            if(this.x > width){
                this.x = -20;
            }
        };
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x -= (float)delta/speed;
            if (this.x<0){
                this.x = width;
            }
        };
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.y -= (float)delta/speed;
            if (this.y<-20){
                this.y = height ;
            }
        };
        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN)){
            this.y += (float)delta/speed;
            if (this.y>height){
                this.y = -20 ;
            }
        };


    }

    public float getX() {
        return x + 100;
    }

    public float getY() {
        return y + 50;
    }


    @Override
    public Shape getShape() {
        return null;
    }
}
