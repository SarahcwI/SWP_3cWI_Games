package at.sarah.games.TurtleSeaMiniGame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trash implements CollissionActor {
    private Image trashImage;
    private float x, y, speed;
    private float rot;
    private int diamter;
    private Shape shapeTrash;
    private boolean isHit = false;
    private List<CollissionActor> collissionActors;
    private int millisSinceHit = 0;



    public Trash() throws SlickException {
        Random random = new Random();
        Image tmp = new Image("testdata/astereoid.png");

        //Trash image
        this.x = random.nextInt(TurtleGameMain.SCREEN_WIDTH) ;
        this.y = random.nextInt(TurtleGameMain.SCREEN_HEIGHT);
        this.speed = random.nextInt(10) + 5;
        this.diamter = random.nextInt(50) + 70;

        //Shape
        //Copy Diameter of picture to shape
        this.trashImage = tmp.getScaledCopy(diamter, diamter);
        float radius = diamter / 2.0f;
        this.shapeTrash = new Circle(this.x, this.y + radius, radius);

        this.collissionActors = new ArrayList<>();
    }

    public void addCollisionActor(CollissionActor collissionActor) {
        this.collissionActors.add(collissionActor);
    }


    @Override
    public void render(Graphics graphics) {
        //make Trash Dissapear
        if (isHit) return;

        //Set color of shape to Red
        if (isHit) {graphics.setColor(Color.red);}

        //Draw Trash and shape
        trashImage.draw(this.x, this.y);
        trashImage.setRotation(rot);
        graphics.draw(this.shapeTrash);
        graphics.setColor(Color.white);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        this.x += (float) delta / speed;
        this.shapeTrash.setX(this.x);

        //Resetting Trash to begining of screen
        if (this.x > TurtleGameMain.SCREEN_WIDTH) {
            this.x = 0;
            this.shapeTrash.setX(this.x);
            this.y = random.nextInt(TurtleGameMain.SCREEN_HEIGHT);
            this.shapeTrash.setY(this.y);

            //make function bool and then if hit set true 
        }

        rot += delta * 0.1f;
        if (rot > 360) {
            rot -= 360;
        }

        checkCollision();
    }




    @Override
    public Shape getShape() {
        return shapeTrash;
    }

    @Override
    public void isHit() {
        System.out.println("I am hit");
        this.isHit = true;
    }

    private void checkCollision() {
        for (CollissionActor collissionActor : this.collissionActors) {
            if (collissionActor.getShape().intersects(this.getShape())) {
                System.out.println("Trash Collission...");
            }
        }
    }
}
