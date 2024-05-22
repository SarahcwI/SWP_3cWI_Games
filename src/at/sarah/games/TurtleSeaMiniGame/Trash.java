package at.sarah.games.TurtleSeaMiniGame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import java.util.Random;

public class Trash implements CollissionActor {

    private Image trashImage;
    private float x, y, speed;
    private float rot;
    private int diamter;
    private Shape shapeTrash;



    public Trash() throws SlickException {
        Random random = new Random();
        Image tmp = new Image("testdata/astereoid.png");

        //picture
        this.x = random.nextInt(RocketGameMain.SCREEN_WIDTH) ;
        this.y = random.nextInt(RocketGameMain.SCREEN_HEIGHT);

        //object
        this.speed = random.nextInt(10) + 5;
        this.diamter = random.nextInt(50) + 70;

        //Copy Diameter of picture to shape
        this.trashImage = tmp.getScaledCopy(diamter, diamter);

        float radius = diamter / 2.0f;
        this.shapeTrash = new Circle(this.x, this.y + radius, radius);
    }


    @Override
    public void render(Graphics graphics) {
        trashImage.draw(this.x, this.y);
        trashImage.setRotation(rot);
        graphics.draw(this.shapeTrash);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        Random random = new Random();
        this.x += (float) delta / speed;
        this.shapeTrash.setX(this.x);

        if (this.x > RocketGameMain.SCREEN_WIDTH) {
            this.x = 0;
            this.shapeTrash.setX(this.x);

            this.y = random.nextInt(RocketGameMain.SCREEN_HEIGHT);
            this.shapeTrash.setY(this.y);
        }

        rot += delta * 0.1f;
        if (rot > 360) {
            rot -= 360;
        }

    }


    @Override
    public Shape getShape() {
        return shapeTrash;
    }
}
