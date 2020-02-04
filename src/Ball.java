import java.awt.*;

public class Ball {
    private int x, y;
    private final int diameter = 25;
    private final int SPEED = 4;
    double dx = SPEED, dy = SPEED;

    Board board;
    Enemy[][] enemies;

    public Ball(Board board){
        x = 0;
        y = 0;

        this.board = board;
    }

    public void setPosition(int x, int y){
        this.x = x - diameter/2;
        this.y = y - diameter/2;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, diameter, diameter);
    }

    public void checkCollisions(Paddle other){
        if(getBounds().intersects(other.getBounds())){
            if(x < board.getWidth()/2){
                dy *= -1;
                setPosition(x, y+1);
            }
            if(x > board.getWidth()/2){
                dy *= -1;
                setPosition(x, y-1);
            }
        }
    }

    public void move(){
        if(x <= 0){
            dx*=-1;
        }
        if(x + diameter >= board.getWidth()){
            dx*=-1;
        }
        if(y <= 0 || y + diameter >= board.getHeight()){
            dy*=-1;
        }
        x += dx;
        y += dy;
    }


    public void setDy(double dy){this.dy = dy;}

    public double getDy(){return dy;}

    public void paint(Graphics g){
        g.fillOval(x,y,diameter,diameter);
    }
}
