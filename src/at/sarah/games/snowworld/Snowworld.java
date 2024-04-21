package at.sarah.games.snowworld;

import at.sarah.games.firstgame.ObjectsGame;
import org.newdawn.slick.*;

public class Snowworld extends BasicGame {

    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

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
