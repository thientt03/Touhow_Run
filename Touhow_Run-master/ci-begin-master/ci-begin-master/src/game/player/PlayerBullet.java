package game.player;

import game.GameObject;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

public class PlayerBullet extends GameObject {
    public int damage;

    public PlayerBullet() {
//        image = SpriteUtils.loadImage("");
        renderer = new Renderer("C:\\\\Users\\\\thien\\\\Desktop\\\\Touhow_Run-master\\\\Touhow_Run-master\\\\ci-begin-master\\\\ci-begin-master\\\\assets\\\\images\\\\player-bullets\\\\a");
        velocity.set(0,-3);
        hitBox = new BoxCollider(this,24,24);
        damage = 1;
    }
    @Override
    public void run(){
        //tốc độ của viên đạn
        super.run();
        this.deactiveIfNeeded();
        this.checkEnemy();
    }

    public void checkEnemy() {
        Enemy enemy = GameObject.findIntersect(Enemy.class, hitBox);
        if (enemy != null){
            enemy.takeDamage(damage);
            this.deactive();
        }
    }

    public void deactiveIfNeeded(){
        if (position.y < -30){
            this.deactive();
        }
    }

}
