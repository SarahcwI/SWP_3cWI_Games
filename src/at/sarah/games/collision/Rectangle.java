package at.sarah.games.collision;

import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Rectangle implements Actor {
    private int x,y;
    private Shape shape = new org.newdawn.slick.geom.Rectangle(this.x, this.y,100,100);
    @Override
    public void render(Graphics graphics) {
        //graphics.drawRect(this.x,this.y,100,100);
        graphics.draw(shape);
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x++;
        this.shape.setX(this.x);
        if (x>1000){
            this.x=0;
        }
    }
}
