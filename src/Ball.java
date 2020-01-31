import java.awt.*;

public class Ball {
    private int x, y;
    private final int diameter = 25;

    Board board;

    public Ball(Board board){
        x = 0;
        y = 0;

        this.board = board;
    }

    public void setPosition(int x, int y){
        this.x = x - diameter/2;
        this.y = y - diameter/2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void paint(Graphics g){
        g.fillOval(x,y,diameter,diameter);
    }
}
