package at.sarah.games.TurtleSeaMiniGame;


import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;


public class TurtleGameMain extends BasicGame {
    private List<Actor> actorsList;
    private List<Trash> trashList;
    private Turtle turtle;
    private Input input;

    private int timeSinceLastBullet = 0;
    public static final int SCREEN_HEIGHT = 1500;
    public static final int SCREEN_WIDTH = 1500;

    public TurtleGameMain(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        input = gameContainer.getInput();
        this.actorsList = new ArrayList<>();
        this.trashList = new ArrayList<>();

        //Turtle
        Turtle turtle = new Turtle();
        this.turtle = turtle;
        actorsList.add(turtle);

        //Adding trash to lists for collision
        for (int i = 0; i < 10; i++) {
            Trash trash = new Trash();
            actorsList.add(trash);
            trashList.add(trash);
            this.turtle.addCollisionActor(trash);
        }
    }


    /*@Override
    public void keyPressed(int key, char c) {

    }*/

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actorsList) {
            actor.update(gameContainer, delta);
        }

        if (input.isKeyDown(Input.KEY_SPACE)) {
            this.timeSinceLastBullet += delta;

            //craeating new Laser in intervals
            if (timeSinceLastBullet > 100) {
                Laser laser = new Laser(this.turtle.getX() + 5, this.turtle.getY() + 10);
                this.actorsList.add(laser);

                //addin trash to collision of laser - Laser knows trashes
                for (Trash trash : trashList) {
                    laser.addCollisionActor(trash);
                }

                timeSinceLastBullet = 0;
            }
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
            AppGameContainer container = new AppGameContainer(new TurtleGameMain("Rectangles"));
            container.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
