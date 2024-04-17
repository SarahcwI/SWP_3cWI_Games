package at.sarah.games.firstgame;

import org.newdawn.slick.*;


public class Rectangles extends BasicGame {
    public enum Direction {RIGHT, DOWN, LEFT, UP}
    private float recx;
    private float recy;
    private float ovx;
    private float ovy;
    private float recSpeed;
    private Direction actualDirection = Direction.RIGHT;




    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.recx = 100;
        this.recy = 100;
        this.ovy = 0;
        this.ovx = 100;
        this.recSpeed = 4.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        double windowBoarderHorizontalRight = gameContainer.getWidth() * 0.8;
        double windowBoarderHorizontalLeft = gameContainer.getWidth() * 0.1;
        double windowBoarderVerticalDown = gameContainer.getHeight() * 0.8;
        double windowBoarderVerticalUp = gameContainer.getHeight() * 0.1;


        if (actualDirection==Direction.RIGHT){
            this.recx = moveRight(this.recx, delta);
            int newNumber = Math.round(this.recx);
            System.out.println("new:" + newNumber + " : " + windowBoarderHorizontalRight);
            if (newNumber > windowBoarderHorizontalRight){
                System.out.println("Bigger");
                this.actualDirection = Direction.DOWN;
                System.out.println("DOWN");
            }
        }
        if (actualDirection==Direction.DOWN){
            this.recy = moveDown(this.recy, delta);
            int newNumber = Math.round(this.recy);
            if (newNumber> windowBoarderVerticalDown){
                this.actualDirection = Direction.LEFT;
                System.out.println("LEFT");
            }
        }
        if (actualDirection==Direction.LEFT){
            this.recx = moveLeft(this.recx, delta);
            int newNumber = Math.round(this.recx);
            //System.out.println("x: " + this.recx);
            if (newNumber < windowBoarderHorizontalLeft ){
                this.actualDirection = Direction.UP;
                System.out.println("UP");
            }


        }

        if (actualDirection==Direction.UP){
            this.recy = moveUp(this.recy, delta);
            int newNumber = Math.round(this.recy);
            if (newNumber < windowBoarderVerticalUp){
                this.actualDirection = Direction.RIGHT;
                System.out.println("RIGHT");
            }
        }



//        if (actualDirection==Direction.RIGHT){
//            this.ovx = moveRight(this.ovx, delta);
//            if (this.ovx>windowBoarderHorizontalRight){
//                this.actualDirection = Direction.LEFT;
//            }
//
//
//        }
//
//        if (actualDirection==Direction.LEFT){
//            this.ovx = moveLeft(this.ovx, delta);
//            if (this.ovx<=windowBoarderHorizontalLeft){
//                this.actualDirection = Direction.RIGHT;
//            }
//        }

        /*if (this.ovx < 800 ){
            actualDirection = true;
        }

        else if (this.ovx > 800){
            actualDirection = false;
        }


        if (actualDirection) {
            this.ovx = moveRight(this.ovx, delta);
            System.out.println("x" + this.ovx);
            System.out.println("Going Right");
        }

        else if (!actualDirection) {
            this.ovx = moveLeft(this.ovx, delta);
            System.out.println("x" + this.ovx);
            System.out.println("Going Left");
        }*/

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.recx,this.recy,100,100);
        graphics.drawOval(this.ovx, this.ovy, 100, 50);
        graphics.drawString("Hello World!", 50, 50);

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(1000,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }





    public float moveRight(float xChord, int delta){
       return xChord + (float)delta/this.recSpeed;
    }

    public float moveLeft(float xChord, int delta){
        return xChord -= (float)delta/this.recSpeed;
    }

    public float moveUp(float yChord, int delta) {
        return yChord -= (float) delta / this.recSpeed;
    }

    public float moveDown(float yChord, int delta){
        return yChord += (float)delta/this.recSpeed;
    }



    /*
        if (this.ovx >= 700){
            this.isFacingRight = false;
        }

        if(this.ovx <= 100){
            this.isFacingRight = true;
        }

        if (this.isFacingRight) {
            System.out.println(this.ovx + " <= 700");
            this.ovx = (this.ovx, delta);
        }

        if (!this.isFacingRight) {
            System.out.println(this.ovx + " >= 100");
            this.ovx = Move(this.ovx, -delta);

        public float Move(float yChord, int delta){
        return yChord + (float)delta/this.recSpeed;
    }*/

}
