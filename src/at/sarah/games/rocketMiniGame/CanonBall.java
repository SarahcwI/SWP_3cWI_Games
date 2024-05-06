package at.sarah.games.rocketMiniGame;

import at.sarah.games.collision.CollissionActor;
import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class CanonBall implements CollissionActor {
    private float x,y,speed;

    public CanonBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 1;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y,10,10);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x+= (float) delta/speed;

    }

    @Override
    public Shape getShape() {
        return null;
    }
}
