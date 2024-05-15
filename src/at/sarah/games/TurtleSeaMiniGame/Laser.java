package at.sarah.games.TurtleSeaMiniGame;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Laser implements CollissionActor {
    private float x,y,speed;

    public Laser(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 1;
          }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x, this.y,40,7);
        graphics.setColor(new Color(255,0,0));
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
