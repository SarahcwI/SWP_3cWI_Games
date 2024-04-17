package at.sarah.games.firstgame;

import org.newdawn.slick.*;


public class Rectangles extends BasicGame {
    public enum Direction {RIGHT, DOWN, LEFT, UP}
    public enum Direction1 {RIGHT, DOWN, LEFT, UP}
    public enum Direction2 {RIGHT, DOWN, LEFT, UP}
    private float recx;
    private float recy;
    private float ovx;
    private float ovy;
    private float circx;
    private float circy;
    private float Speed;
    private Direction actualDirectionRec = Direction.RIGHT;
    private Direction1 actualDirectionOv = Direction1.RIGHT;
    private Direction2 actualDirectionCirc = Direction2.DOWN;




    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.recx = 100;
        this.recy = 100;
        this.ovy = 0;
        this.ovx = 100;
        this.circx = 0;
        this.Speed = 4.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        double windowBoarderHorizontalRight = gameContainer.getWidth() * 0.8;
        double windowBoarderHorizontalLeft = gameContainer.getWidth() * 0.1;
        double windowBoarderVerticalDown = gameContainer.getHeight() * 0.8;
        double windowBoarderVerticalUp = gameContainer.getHeight() * 0.1;


        if (actualDirectionRec==Direction.RIGHT){
            this.recx = moveRight(this.recx, delta);
            int newNumber = Math.round(this.recx);
            System.out.println("new:" + newNumber + " : " + windowBoarderHorizontalRight);
            if (newNumber > windowBoarderHorizontalRight){
                System.out.println("Bigger");
                this.actualDirectionRec = Direction.DOWN;
                System.out.println("DOWN");
            }
        }
        if (actualDirectionRec==Direction.DOWN){
            this.recy = moveDown(this.recy, delta);
            int newNumber = Math.round(this.recy);
            if (newNumber> windowBoarderVerticalDown){
                this.actualDirectionRec = Direction.LEFT;
                System.out.println("LEFT");
            }
        }
        if (actualDirectionRec==Direction.LEFT){
            this.recx = moveLeft(this.recx, delta);
            int newNumber = Math.round(this.recx);
            //System.out.println("x: " + this.recx);
            if (newNumber < windowBoarderHorizontalLeft ){
                this.actualDirectionRec = Direction.UP;
                System.out.println("UP");
            }


        }

        if (actualDirectionRec==Direction.UP){
            this.recy = moveUp(this.recy, delta);
            int newNumber = Math.round(this.recy);
            if (newNumber < windowBoarderVerticalUp){
                this.actualDirectionRec = Direction.RIGHT;
                System.out.println("RIGHT");
            }
        }



        if (actualDirectionOv==Direction1.RIGHT){
            this.ovx = moveRight(this.ovx, delta);
            if (this.ovx>windowBoarderHorizontalRight){
                this.actualDirectionOv = Direction1.LEFT;
            }


        }

        if (actualDirectionOv==Direction1.LEFT){
           this.ovx = moveLeft(this.ovx, delta);
           if (this.ovx<=windowBoarderHorizontalLeft){
                this.actualDirectionOv = Direction1.RIGHT;
            }
        }


        if(actualDirectionCirc==Direction2.DOWN){
            System.out.println("Hallo");
            this.circy = moveDown(this.circy,delta);
            if(this.circy >= windowBoarderVerticalDown){
                this.actualDirectionCirc = Direction2.UP;
            }
        }

        if(actualDirectionCirc==Direction2.UP){
            this.circy = moveUp(this.circy,delta);
            if(this.circy <= windowBoarderVerticalUp){
                this.actualDirectionCirc = Direction2.DOWN;
            }
        }



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
        graphics.drawOval(this.circx, this.circy, 80,80);
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
       return xChord + (float)delta/this.Speed;
    }

    public float moveLeft(float xChord, int delta){
        return xChord -= (float)delta/this.Speed;
    }

    public float moveUp(float yChord, int delta) {
        return yChord -= (float) delta / this.Speed;
    }

    public float moveDown(float yChord, int delta){
        return yChord += (float)delta/this.Speed;
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
