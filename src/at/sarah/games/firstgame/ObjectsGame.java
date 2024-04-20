package at.sarah.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ObjectsGame extends BasicGame {
    private List<Rectangle> rectanglesList;
    private Circle circle;
    private Oval oval;

    public ObjectsGame(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.rectanglesList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(gameContainer.getWidth()), random.nextInt(gameContainer.getHeight()),random.nextInt(50));
            rectanglesList.add(rectangle);

        }

        //this.circle = new Circle(100,100,7);
        //this.oval = new Oval(0,400,5);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Rectangle rectangle: this.rectanglesList){
            rectangle.update(delta);
        }


        //this.circle.update(delta);
        //this.oval.update(delta);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Rectangle rectangle: this.rectanglesList){
            rectangle.render(graphics);
        }

        //this.circle.render(graphics);
        //this.oval.render(graphics);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(1000,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
