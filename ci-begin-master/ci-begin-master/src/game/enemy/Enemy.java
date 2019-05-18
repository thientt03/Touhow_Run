package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public int hp;
    public Enemy(){
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\enemies\\level0\\black\\0.png");
        position.set(0,-50);
        velocity.set(0,3);
        velocity.setAngle(Math.toRadians(25));
        hitBox = new BoxCollider(this,28,28);
        hp = 3;
    }
    public void takeDamage(int damage){
        hp -= damage;
        if (hp <= 0){
            hp = 0;
            this.deactive();
        }
    }
    int count = 0;
    @Override
    public void run() {
        super.run();// velocity
        this.move();
        this.enemyFire();
        this.deactiveIfNeedes();

    }

    private void move() {
        if (this.onGoingRinght() && this.outofBoundRight()) {
            this.reverseVelocityX();
        }
        if (velocity.x < 0 && position.x < 0) {
            velocity.x = -velocity.x;
        }
    }

    @Override
    public void reset() {
        super.reset();
        position.set(0,-50);
        velocity.set(0,3);
        velocity.setAngle(Math.toRadians(25));
        hp = 3;
    }

    public void deactiveIfNeedes() {
        if (position.y > 800){
            this.deactive();
        }
    }

    public void reverseVelocityX() {
        velocity.x = - velocity.x;
    }

    public boolean outofBoundRight() {
        return position.x  > 384 - 32;
    }

    public boolean onGoingRinght() {
        return velocity.x > 0;
    }

    public void enemyFire() {
        count++;
        if ( count >= 20){
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x,this.position.y);
            count = 0;
        }
    }
}
