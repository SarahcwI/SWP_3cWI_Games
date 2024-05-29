package at.sarah.games.TurtleSeaMiniGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;


public class Laser implements CollissionActor {
    private float x, y, speed;
    private Shape laserShape;
    private List<CollissionActor> collissionActors;



    public Laser(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 1;
        this.laserShape = new Rectangle(this.x, this.y,70,7 );
        this.collissionActors = new ArrayList<>();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x, this.y, 40, 7);
        graphics.setColor(new Color(255, 255, 0));
        graphics.draw(laserShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.x += (float) delta / speed;
        laserShape.setX(this.x);

        checkCollision();
    }

    @Override
    public Shape getShape() {
        return laserShape;
    }


    public void addCollisionActor(CollissionActor collissionActor) {
        this.collissionActors.add(collissionActor);
    }


    private void checkCollision() {
        for (CollissionActor collissionActor : this.collissionActors) {
            if (collissionActor.getShape().intersects(this.getShape())) {
                System.out.println("COLLISSION...");
            }
        }
    }

}


