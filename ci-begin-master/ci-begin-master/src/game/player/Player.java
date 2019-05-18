package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

public class Player extends GameObject {
    public Player(){
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        position.set(200,500);
        hitBox = new BoxCollider(this,32,48);

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
                this.die();

    }

    public void die(){
        Enemy enemy = GameObject.findIntersect(Enemy.class,hitBox);
        if (enemy!= null){
            this.deactive();
        }
    }
    private void fire() {
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

    private void limitPosition() {
        position.x = Mathx.clamp(position.x,0,384-32);
        position.y = Mathx.clamp(position.y,0,800-48);
    }

    private void move() {
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
