package at.sarah.games.rocketMiniGame;

import at.sarah.games.collision.CollissionActor;
import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Astereoid implements CollissionActor {

    private Image astereoid;
    private float x,y,speed;
    private float rot;
    private int diamter;
    private Shape shape;


    public Astereoid() throws SlickException {
        Random random = new Random();
        Image tmp = new Image("testdata/astereoid.png");
        this.diamter = random.nextInt(50) + 70;

        this.astereoid = tmp.getScaledCopy(diamter,diamter);

        this.x = random.nextInt(1000);
        this.y = random.nextInt(1000);
        this.speed = random.nextInt(10) + 10;
        float radius = diamter / 2.0f;
        this.shape = new Circle(this.x, this.y + radius, radius);

    }


    @Override
    public void render(Graphics graphics) {
        astereoid.draw(this.x, this.y);
        astereoid.setRotation(rot);
        graphics.draw(shape);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        this.x += (float)delta/speed;
        this.shape.setX(this.x);


        if (this.x > 1000){
            this.x = 0;
            this.y = random.nextInt(1000);
            shape.setY(this.y);
        }

        rot += delta * 0.1f;
        if (rot > 360) {
            rot -= 360;
        }

    }

    @Override
    public Shape getShape() {
        return null;
    }
}
