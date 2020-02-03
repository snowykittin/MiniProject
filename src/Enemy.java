import java.awt.*;

public class Enemy {
    int x, y = 30;
    int width = 70;
    int height = 30;
    int speed, dx, dy = 5;
    int numEnemies = 50;

    public Enemy(){
        x = 50;
        y = 50;
    }

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }

    public int getNumEnemies(){
        return numEnemies;
    }
}
