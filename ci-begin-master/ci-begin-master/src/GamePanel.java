import tklibs.Mathx;
import tklibs.SpriteUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage backgroundImage;
    Vector2D backgroundPosition;
//    int backgroundY;
//    int backgroundX;
    BufferedImage playerImage;
    Vector2D playPosition;
//    int playerX;
//    int playerY;
    public GamePanel(){
        playerImage = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        playPosition = new Vector2D(200,500);
        backgroundImage = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\ci-begin-master\\ci-begin-master\\assets\\images\\background\\0.png");
        backgroundPosition = new Vector2D(0,800-3109);
//        backgroundX = 0;
//        backgroundY = 800-3109;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage,(int) backgroundPosition.x, (int) backgroundPosition.y,null);
        g.drawImage(playerImage,(int) playPosition.x,(int) playPosition.y,null);

//        g.setColor(Color.YELLOW);
//        g.drawRect(100, 100, 100, 100);
//        g.fillRect(200,200,100,100);
    }
    public void GameLoop(){
        long lastTime = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000/60){
                //run logic
                this.runAll();

                //render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
    public void runAll(){
//        System.out.println(playPosition.y);
        //player run
        if (KeyEventPress.isUPPress){
            playPosition.y--;
        }
        if (KeyEventPress.isRIGHTPress){
            playPosition.x--;
        }
        if (KeyEventPress.isLEFTPress){
            playPosition.x++;
        }
        if (KeyEventPress.isDOWNPress){
            playPosition.y++;
        }
        playPosition.x = Mathx.clamp(playPosition.x,0,384-32);
        playPosition.y = Mathx.clamp(playPosition.y,0,800-48);
        //background run
        backgroundPosition.y += 5;
        if(backgroundPosition.y >= 0){
            backgroundPosition.y = 0;
        }
    }
}
