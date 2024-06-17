package at.sarah.games.TurtleSeaMiniGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Turtle implements CollissionActor {
    private Image turtleImage;
    private float x, y;
    private float speed;
    private float rot;
    private List<CollissionActor> collissionActors;
    private Shape shapeTurtle;
    private int hitCounter = 0;
    public static final float Y_OFFSET = 29;


    public Turtle() throws SlickException {
        //Turtle Image
        Image tmp = new Image("testdata/turtle.png");
        int imageRadius = 120;
        this.turtleImage = tmp.getScaledCopy(imageRadius, imageRadius);
        this.x = 100;
        this.y = 100;
        this.speed = 2;
        this.rot = 0;

        this.collissionActors = new ArrayList<>();

        //Collision Shape
        int ellipseWidth = imageRadius / 2;
        float ellipseHeight = imageRadius / 3f;
        float centerPointEllipseX = this.x + ellipseWidth;
        float centerPointEllipseY = this.y + ellipseHeight * 1.8f;
        this.shapeTurtle = new Ellipse(centerPointEllipseX, centerPointEllipseY, ellipseWidth, ellipseHeight);
    }

    public void addCollisionActor(CollissionActor collissionActor) {
        this.collissionActors.add(collissionActor);
    }

    @Override
    public void render(Graphics graphipcs) {
        //drawing turtle and rotating image
        turtleImage.draw(this.x, this.y);
        turtleImage.setRotation(rot);

        graphipcs.draw(shapeTurtle);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        int width = TurtleGameMain.SCREEN_WIDTH;
        int height = TurtleGameMain.SCREEN_HEIGHT;

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x += (float) delta / speed;
            shapeTurtle.setX(this.x);
            if (this.x > width) {
                this.x = -20;
                shapeTurtle.setX(this.x);
            }
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x -= (float) delta / speed;
            shapeTurtle.setX(this.x);
            if (this.x < 0) {
                this.x = width;
                shapeTurtle.setX(this.x);
            }
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y -= (float) delta / speed;
            shapeTurtle.setY(this.y + Y_OFFSET);
            if (this.y < -20) {
                this.y = height;
                shapeTurtle.setY(this.y);
            }
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y += (float) delta / speed;
            shapeTurtle.setY(this.y + Y_OFFSET);
            if (this.y > height) {
                this.y = -20;
                shapeTurtle.setY(this.y);
            }
        }
        checkCollision();


    }

    private boolean checkCollision() {
        for (CollissionActor collissionActor : this.collissionActors) {
            //checkin if turtle hits trash
            if (collissionActor.getShape().intersects(this.getShape())) {
                System.out.println("Turtle Collission...");
                return true;
            }
        }
        return false;
    }


    public float getX() {
        return x + 100;
    }

    public float getY() {
        return y + 50;
    }


    @Override
    public Shape getShape() {
        return shapeTurtle;
    }

    @Override
    public void isHit() {

    }
}
