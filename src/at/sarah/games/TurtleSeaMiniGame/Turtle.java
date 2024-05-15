package at.sarah.games.TurtleSeaMiniGame;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Turtle implements CollissionActor {
    private Image turtleImage;
    private float x, y;
    private float speed;
    private float rot;
    private List<CollissionActor> collissionActors;



    public Turtle() throws SlickException {
        Image tmp = new Image("testdata/turtle.png");
        this.turtleImage = tmp.getScaledCopy(120, 120);
        this.x = 100;
        this.y = 100;
        this.speed = 2;
        this.rot = 0;
        this.collissionActors = new ArrayList<>();
    }

    public void addCollisionActor(CollissionActor collissionActor) {
        this.collissionActors.add(collissionActor);
    }

    @Override
    public void render(Graphics graphipcs){
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        int width = RocketGameMain.SCREEN_WIDTH;
        int height = RocketGameMain.SCREEN_HEIGHT;

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x += (float) delta / speed;
            if (this.x > width) {
                this.x = -20;
            }
        }
        ;
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x -= (float) delta / speed;
            if (this.x < 0) {
                this.x = width;
            }
        }
        ;
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y -= (float) delta / speed;
            if (this.y < -20) {
                this.y = height;
            }
        }
        ;
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y += (float) delta / speed;
            if (this.y > height) {
                this.y = -20;
            }
        }
        ;

        checkCollision();
    }

    private void checkCollision() {
        for (CollissionActor collissionActor : this.collissionActors) {
            /*if (collissionActor.getShape().intersects(this.getShape())) {
                System.out.println("Collission...");
            }*/
        }
    }

    public float getX() {
        return x + 100;
    }

    public float getY() {
        return y + 50;
    }


   /* @Override
    public Shape getShape() {
        return null;
    }*/
}
