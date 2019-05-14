package game.player;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {

    public PlayerBullet() {
        this.position = new Vector2D();
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\player-bullets\\a\\1.png");
    }
    @Override
    public void run(){
        //tốc độ của viên đạn
        this.position.y -= 3;
        this.deactiveIfNeeded();
    }
    private void deactiveIfNeeded(){
        if (position.y < -30){
            this.deactive();
        }
    }

}
