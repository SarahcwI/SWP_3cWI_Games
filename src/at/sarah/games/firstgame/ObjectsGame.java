package at.sarah.games.firstgame;

import org.newdawn.slick.*;


public class ObjectsGame extends BasicGame {
    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Circle circle;
    private Oval oval;

    public ObjectsGame(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangle = new Rectangle(100, 100, 5);
        this.rectangle2 = new Rectangle(5,20,5);
        this.circle = new Circle(100,100,7);
        this.oval = new Oval(0,400,5);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.rectangle.update(delta);
        this.rectangle2.update(delta);
        this.circle.update(delta);
        this.oval.update(delta);

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.rectangle.render(graphics);
        this.rectangle2.render(graphics);
        this.circle.render(graphics);
        this.oval.render(graphics);
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
