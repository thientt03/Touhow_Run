package game;

import game.enemy.EnemySummoner;
import game.player.Player;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
//    Enemy enemy;

    public GamePanel(){
        this.background = new Background();
        this.player = new Player();
        EnemySummoner es = new EnemySummoner();
        Item it = new Item();
    }

    @Override
    public void paint(Graphics g) {
        for (int i =0; i < GameObject.objects.size(); i++){
            GameObject object = GameObject.objects.get(i);
            if (object.active){
                object.render(g);
            }
        }
        //chỉnh sửa sau (tobe countiue.....)
        g.setColor(Color.BLACK);
        g.fillRect(385,0,800-384,800);
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
        //player run
        player.run();
        //background run
        background.run();
        //bullet run
        for (int i =0; i < GameObject.objects.size(); i++){
            GameObject object = GameObject.objects.get(i);
            if (object.active){
                object.run();
            }
        }
    }
}
