import java.awt.*;

public class Paddle {
    private int x, y;
    private final int WIDTH = 125, HEIGHT = 15;
    Board board;
    Game game;
    private int dx = 5;

    public Paddle(Board board, Game game){
        y = 0;
        x = 0;
        this.board = board;
        this.game = game;
    }

    public void setPosition(int x, int y){
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
    }

    public void moveRight(){
        x+=dx;
    }

    public void moveLeft(){
        x-=dx;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getX(){
        return x;
    }

    public int getWIDTH(){
        return WIDTH;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
}
