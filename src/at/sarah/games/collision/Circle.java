package at.sarah.games.collision;

import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Actor {
    private List<CollissionActor> collissionActors = new ArrayList<>();
    private Shape shape = new org.newdawn.slick.geom.Circle(150,100,50);
    private boolean isHit = false;

    @Override
    public void render(Graphics graphics) {
       // graphics.drawOval(100,50,100,100);

        if (isHit){
            graphics.setColor(new Color(100,100,100));
        }

        graphics.draw(shape);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for (CollissionActor actor: this.collissionActors) {
            Shape collisssionShape = actor.getShape();
            if (collisssionShape.intersects(this.shape)){
               isHit=true;
            }
        }
    }

    public void addCollissionActor(CollissionActor actor){
        this.collissionActors.add(actor);
    }
}
