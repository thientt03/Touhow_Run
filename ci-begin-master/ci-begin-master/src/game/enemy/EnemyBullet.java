package game.enemy;

import game.GameObject;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {

    public EnemyBullet(){
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\bullets\\blue.png");
        position.set(position.x,position.y);
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public void run() {
        position.y += 5;
        this.deactiveIfNeeded();
    }

    public void deactiveIfNeeded() {
        if (position.y < 50){
            this.deactive();
        }
    }

}
