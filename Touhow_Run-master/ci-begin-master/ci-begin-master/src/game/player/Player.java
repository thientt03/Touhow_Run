package game.player;

import game.GameObject;
import game.Item;
import game.KeyEventPress;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;

public class Player extends GameObject {
    public int hp;
    public boolean immune;
    public Player(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight");
        position.set(200,500);
        hitBox = new BoxCollider(this,32,48);
        hp = 3;
        immune = false;
    }

    int renderCount = 0;
    @Override
    public void render(Graphics g) {
        if (immune){
            renderCount++;
            if (renderCount % 3 == 0) {
                super.render(g);
            }
        }else {
                super.render(g);
        }
    }

    int count = 0;//đếm số khung hình
    @Override
    public void run(){
                //60 fps --> 60 khung hình trên(s) ---> giữ space thì sẽ có 60 viên đạn tạo ra trong vòng 1(s)--> muốn có 3 viên 1(s) thôi
                //run logic
                this.move();

                //giới hạn vị trí
                this.limitPosition();

                //bắn đạn
                this.fire();

                this.checkImmune();

                this.checkItem();

    }
    public void checkItem(){
        Item item = GameObject.findIntersect(Item.class, hitBox);
        if (item != null){
            item.deactive();
            hp += 1;
        }
    }

    int immuneCount =0;
    public void checkImmune() {
        if (immune){
            immuneCount++;
            if (immuneCount > 120){
                immune = false;
            }
        }else {
            immuneCount = 0;
        }

    }

    public void takeDamage(int damage){
        if (!immune){
            hp -= damage;
            if (hp <= 0){
                hp = 0;
                this.deactive();
            } else {
                // rơi vào trạng thái bất tử
                immune = true;
            }
        }
    }


    public void fire() {
        count++;
        if(KeyEventPress.isFirePress && count > 20){
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x,this.position.y);
            bullet.velocity.setAngle(Math.toRadians(-90));

            PlayerBullet bullet1 = GameObject.recycle(PlayerBullet.class);
            bullet1.position.set(this.position.x-15,this.position.y);
            bullet1.velocity.setAngle(Math.toRadians(-135));

            PlayerBullet bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet2.position.set(this.position.x+10,this.position.y);
            bullet2.velocity.setAngle(Math.toRadians(-45));

            count = 0;
        }
    }

    public void limitPosition() {
        position.x = Mathx.clamp(position.x,0,384-32);
        position.y = Mathx.clamp(position.y,0,800-48);
    }

    public void move() {
        if (KeyEventPress.isUPPress){
            position.y--;
        }
        if (KeyEventPress.isRIGHTPress){
            position.x--;
        }
        if (KeyEventPress.isLEFTPress){
            position.x++;
        }
        if (KeyEventPress.isDOWNPress){
            position.y++;
        }
    }


}
