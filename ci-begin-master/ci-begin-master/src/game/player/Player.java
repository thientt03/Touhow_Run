package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
//    public static ArrayList<PlayerBullet>playerBullets = new ArrayList<>();

    public Player(){
        image = SpriteUtils.loadImage("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        position.set(200,500);
    }

    int count = 0;//đếm số khung hình
    @Override
    public void run(){//60 fps --> 60 khung hình trên(s) ---> giữ space thì sẽ có 60 viên đạn tạo ra trong vòng 1(s)--> muốn có 3 viên 1(s) thôi
                //run logic
                this.move();

                //giới hạn vị trí
                this.limitPosition();

                //bắn đạn
                this.fire();

                //playerBullets run
//                this.bulletsRun();
//        System.out.println(GameObject.objects.size());

    }

//    private void bulletsRun() {
//        for (int i = 0; i < playerBullets.size(); i++){
//            PlayerBullet bullet = playerBullets.get(i);
//            bullet.run();
//        }
//    }

    private void fire() {
        count++;
        if(KeyEventPress.isFirePress && count > 20){
//            PlayerBullet bullet = new PlayerBullet();
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x,this.position.y);

            PlayerBullet bullet1 = GameObject.recycle(PlayerBullet.class);
            bullet1.position.set(this.position.x-15,this.position.y);

            PlayerBullet bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet2.position.set(this.position.x+10,this.position.y);

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
