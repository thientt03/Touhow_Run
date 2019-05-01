import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends JPanel {
    BufferedImage backgroundImage;
    Vector2D backgroundPosition;

    public Background(){
        backgroundImage = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\ci-begin-master\\ci-begin-master\\assets\\images\\background\\0.png");
        backgroundPosition = new Vector2D(0,800-3109);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage,(int) backgroundPosition.x,(int) backgroundPosition.y,null);
    }
    public void GameLoop(){
        long lastTime = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000/60){
                //run logic
                backgroundPosition.y += 5;
                if (backgroundPosition.y >= 0){
                    backgroundPosition.y = 0;
                }

                //render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
