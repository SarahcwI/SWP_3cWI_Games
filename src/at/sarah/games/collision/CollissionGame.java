package at.sarah.games.collision;

import at.sarah.games.firstgame.Actor;
import at.sarah.games.firstgame.ObjectsGame;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class CollissionGame extends BasicGame {
    private List<Actor> actors = new ArrayList<>();


    public CollissionGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Circle circle = new Circle();

        this.actors.add(circle);

        Meteroid m1 = new Meteroid();
        circle.addCollissionActor(m1);
        this.actors.add(m1);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor:actors) {
            actor.update(gameContainer,delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor:actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new CollissionGame("Rectangles"));
            container.setDisplayMode(1000, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
