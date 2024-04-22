package at.sarah.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class CanonBall implements Actor{
    private float x,y,speed;

    public CanonBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 2;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y,10,10);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x+= (float) delta/speed;

    }
}
