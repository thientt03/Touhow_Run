package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(600,800));

        window.add(panel);
        window.pack();

        window.setTitle("MindX-Touhow");
//        window.setSize(600,800);
        window.setLocation(500,0);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUPPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isRIGHTPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isLEFTPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDOWNPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUPPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isRIGHTPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isLEFTPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDOWNPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isFirePress = false;
                }
            }
        };
        window.addKeyListener(keyHandler);
        window.setVisible(true);
        panel.GameLoop();

    }
}
