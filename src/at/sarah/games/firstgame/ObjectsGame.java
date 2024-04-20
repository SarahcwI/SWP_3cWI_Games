package at.sarah.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ObjectsGame extends BasicGame {
    private List<Rectangle> rectanglesList;
    private List<Circle> circlesList;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.rectanglesList = new ArrayList<>();
        this.circlesList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(gameContainer.getWidth()), random.nextInt(gameContainer.getHeight()), random.nextInt(50));
            rectanglesList.add(rectangle);
        }

        for (int i = 0; i < 50; i++) {
            Circle circle = new Circle();
            circlesList.add(circle);

        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Rectangle rectangle : this.rectanglesList) {
            rectangle.update(delta);
        }

        for (Circle circle : this.circlesList) {
            circle.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Rectangle rectangle : this.rectanglesList) {
            rectangle.render(graphics);
        }

        for (Circle circle : this.circlesList) {
            circle.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(1000, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
