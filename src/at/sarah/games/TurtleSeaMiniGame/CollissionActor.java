package at.sarah.games.TurtleSeaMiniGame;


import org.newdawn.slick.geom.Shape;

public interface CollissionActor extends Actor {
    public Shape getShape();
    public void isHit();
}
