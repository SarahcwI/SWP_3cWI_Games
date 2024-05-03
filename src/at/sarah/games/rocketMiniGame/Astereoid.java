package at.sarah.games.rocketMiniGame;

import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Astereoid implements Actor {

    private Image astereoid;
    private float x,y,speed;
    private float rot;
    private int diamter;


    public Astereoid() throws SlickException {
        Random random = new Random();
        Image tmp = new Image("testdata/astereoid.png");
        this.diamter = random.nextInt(50) + 70;

        this.astereoid = tmp.getScaledCopy(diamter,diamter);

        this.x = random.nextInt(1000);
        this.y = random.nextInt(1000);
        this.speed = random.nextInt(10) + 10;

    }


    @Override
    public void render(Graphics graphics) {
        astereoid.draw(this.x, this.y);
        astereoid.setRotation(rot);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        this.x += (float)delta/speed;

        if (this.x > 1000){
            this.x = 0;
            this.y = random.nextInt(1000);
        }

        rot += delta * 0.1f;
        if (rot > 360) {
            rot -= 360;
        }

    }
}
