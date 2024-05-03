package at.sarah.games.rocketMiniGame;

import at.sarah.games.firstgame.Asteriod;
import at.sarah.games.firstgame.Rocket;
import at.sarah.games.firstgame.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;


public class RocketGameMain extends BasicGame {
    private List<Actor> actorsList;
    private Rocket rocket;

    public RocketGameMain(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorsList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Astereoid astereoid = new Astereoid();
            actorsList.add(astereoid);

        }

        Rocket rocket = new Rocket();
        actorsList.add(rocket);

        this.rocket = rocket;
    }


    @Override
    public void keyPressed(int key, char c) {
        if(key == Input.KEY_SPACE){
            System.out.println("huhu");
            CanonBall canonBall = new CanonBall(this.rocket.getX(), this.rocket.getY());
            actorsList.add(canonBall);
        }
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
            AppGameContainer container = new AppGameContainer(new RocketGameMain("Rectangles"));
            container.setDisplayMode(1000, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }



}
