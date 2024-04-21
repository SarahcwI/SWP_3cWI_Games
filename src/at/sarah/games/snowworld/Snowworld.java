package at.sarah.games.snowworld;


import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Snowworld extends BasicGame {
    private List<Actor> actorsList;


    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorsList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Snowflake snowflakeSmall = new Snowflake(Snowflake.Size.small);
            Snowflake snowflakeMedium = new Snowflake(Snowflake.Size.medium);
            Snowflake snowflakeLarge = new Snowflake(Snowflake.Size.large);
            actorsList.add(snowflakeSmall);
            actorsList.add(snowflakeMedium);
            actorsList.add(snowflakeLarge);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actorsList) {
            actor.update(delta);
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
            AppGameContainer container = new AppGameContainer(new Snowworld("Snowworld"));
            container.setDisplayMode(1000, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
