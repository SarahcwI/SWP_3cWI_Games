package at.sarah.games.collision;

import at.sarah.games.firstgame.Actor;
import org.newdawn.slick.geom.Shape;

public interface CollissionActor extends Actor {
    public Shape getShape();
}
