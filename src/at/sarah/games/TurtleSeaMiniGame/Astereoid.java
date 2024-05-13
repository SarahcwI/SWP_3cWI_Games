package at.sarah.games.TurtleSeaMiniGame;

import at.sarah.games.collision.CollissionActor;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Astereoid implements CollissionActor {

    private Image astereoid;
    private float x, y, speed;
    private float rot;
    private int diamter;



    public Astereoid() throws SlickException {
        Random random = new Random();
        Image tmp = new Image("testdata/astereoid.png");

        //picture
        this.x = random.nextInt(RocketGameMain.SCREEN_WIDTH);
        this.y = random.nextInt(RocketGameMain.SCREEN_HEIGHT);
        this.speed = random.nextInt(10) + 10;
        this.diamter = random.nextInt(50) + 70;

        //Copy Diameter of picutre to
        this.astereoid = tmp.getScaledCopy(diamter, diamter);
    }


    @Override
    public void render(Graphics graphics) {
        astereoid.draw(this.x, this.y);
        astereoid.setRotation(rot);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        this.x += (float) delta / speed;

        if (this.x > RocketGameMain.SCREEN_WIDTH) {
            this.x = 0;
            this.y = random.nextInt(RocketGameMain.SCREEN_HEIGHT);
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
