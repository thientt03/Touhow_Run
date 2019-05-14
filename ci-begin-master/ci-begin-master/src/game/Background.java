package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {


    public Background(){
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\background\\0.png");
        position.set(0,800-3109);
    }
    public void run(){
        //run logic
        position.y += 5;
        if (position.y >= 0){
            position.y = 0;
        }
    }
}
