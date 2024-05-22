package at.sarah.games.TurtleSeaMiniGame;



import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;


public class RocketGameMain extends BasicGame {
    private List<Actor> actorsList;
    private Turtle turtle;
    private Input input;

    private int timeSinceLastBullet = 0;
    public static final int SCREEN_HEIGHT = 1500;
    public static final int SCREEN_WIDTH = 1500;

    public RocketGameMain(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorsList = new ArrayList<>();
        input = gameContainer.getInput();
        //input.enableKeyRepeat(0,0);

        Turtle turtle = new Turtle();
        actorsList.add(turtle);

        this.turtle = turtle;

        for (int i = 0; i < 10; i++) {
            Trash trash = new Trash();
            actorsList.add(trash);
            this.turtle.addCollisionActor(trash);

        }
    }




    @Override
    public void keyPressed(int key, char c) {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actorsList) {
            actor.update(gameContainer, delta);
        }

        if (input.isKeyDown(Input.KEY_SPACE)){
            System.out.println("Down");
            this.timeSinceLastBullet += delta;
           if (timeSinceLastBullet>100){
               Laser laser = new Laser(this.turtle.getX() +5, this.turtle.getY()+10);
               actorsList.add(laser);
               timeSinceLastBullet=0;
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
            AppGameContainer container = new AppGameContainer(new RocketGameMain("Rectangles"));
            container.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
