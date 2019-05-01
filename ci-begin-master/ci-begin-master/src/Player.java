import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends JPanel {
    BufferedImage playerImage;
    Vector2D playPosition;

    public Player(){
        playerImage = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        playPosition = new Vector2D(200,500);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(playerImage,(int) playPosition.x,(int) playPosition.y,null);
    }
    public void GameLoop(){
        long lastTime = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000/60){
                //run logic
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

                //render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
