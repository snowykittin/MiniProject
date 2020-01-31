import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame /*implements KeyListener*/{
    private boolean leftPressed, rightPressed;
    private Board board;
    public Game(){
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        setTitle("Brick Breaker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);
        pack();

        setLocationRelativeTo(null);
        board.init();
    }

    public static void main(String[] args){
        new Game();
    }
}
