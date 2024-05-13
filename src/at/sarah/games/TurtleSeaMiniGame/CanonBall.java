package at.sarah.games.TurtleSeaMiniGame;

import at.sarah.games.collision.CollissionActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class CanonBall implements CollissionActor {
    private float x,y,speed;

    public CanonBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 4;
          }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y,20,20);
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
