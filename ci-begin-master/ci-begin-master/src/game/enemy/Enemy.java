package game.enemy;

import game.GameObject;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy(){
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\black\\0.png");
        position.set(200,0);
    }
    public void run(){
        position.x++;
        if(position.x >= (382-32)){
            position.x = 0;
        }
    }
}
