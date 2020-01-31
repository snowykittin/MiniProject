import java.awt.*;

public class Paddle {
    private int x, y;
    private final int WIDTH = 75, HEIGHT = 15;
    Board board;
    Game game;

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

    public void paint(Graphics g){
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
}
