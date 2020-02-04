import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener{
    final int WIDTH = 800;
    final int HEIGHT = 600;
    int score = 0;

    Ball ball;
    Paddle paddle;
    Enemy enemy;
    Enemy[][] enemies = new Enemy[5][15];
    Timer timer;
    Game game;

    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);

        ball = new Ball(this);
        paddle = new Paddle(this, game);
        timer = new Timer(1000/60,this);
        timer.start();
    }

    public void init(){
        ball.setPosition(WIDTH/2,HEIGHT/3*2);
        paddle.setPosition(WIDTH/2, HEIGHT/7*6);
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 15; col++){
                enemies[row][col] = new Enemy(getWidth()/50 + (col*50), (row*50)+20);
            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        ball.paint(g);
        paddle.paint(g);
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 15; col++){
                if(enemies[row][col] != null){
                    enemies[row][col].paint(g);
                }
            }
        }
    }


    public void checkEnemyCollisions(){
        for(int j = 0; j < enemies.length; j++){
            for(int k = 0; k < enemies[0].length; k++){
                if(enemies[j][k] != null){
                    if(ball.getBounds().intersects(enemies[j][k].getBounds())){
                        ball.setDy(ball.getDy()*-1);
                        enemies[j][k] = null;
                        score += 100;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.checkCollisions(paddle);
        checkEnemyCollisions();
        ball.move();
        if(game.isLeftPressed() && (paddle.getX() > 0)){
            paddle.moveLeft();
        }

        if(game.isRightPressed() && (paddle.getX()+ paddle.getWIDTH()) < getWidth()){
            paddle.moveRight();
        }
        repaint();
    }
}
