package at.sarah.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;


public class ObjectsGame extends BasicGame {
    private List<Actor> actorsList;

    public ObjectsGame(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorsList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Asteriod asteriod = new Asteriod();
            actorsList.add(asteriod);

        }


        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(Rectangle.Direction.RIGHT);
            actorsList.add(rectangle);
        }

        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            actorsList.add(circle);

        }

        for (int i = 0; i < 10; i++) {
            Ellipse ellipse = new Ellipse();
            actorsList.add(ellipse);

        }

        Rocket rocket = new Rocket();
        actorsList.add(rocket);


    }


    @Override
    public void keyPressed(int key, char c) {
        System.out.println(key);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actorsList) {
            actor.update(gameContainer, delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actorsList) {
            actor.render(graphics);
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
