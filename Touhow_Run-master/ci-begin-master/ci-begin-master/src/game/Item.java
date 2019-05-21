package game;

import game.physics.BoxCollider;
import game.renderer.Renderer;

public class Item extends GameObject {
    public Item(){
        renderer = new Renderer("C:\\Users\\thien\\Desktop\\Touhow_Run-master\\Touhow_Run-master\\ci-begin-master\\ci-begin-master\\assets\\images\\items\\power-up-red.png");
        hitBox = new BoxCollider(this,12,12);
        position.set(200,200);
    }

    public void run() {
        super.run();
        position.y += 5;
        this.deactiveIfNeeded();
    }

    public void deactiveIfNeeded() {
        if (position.y < 50){
            this.deactive();
        }
    }

}
