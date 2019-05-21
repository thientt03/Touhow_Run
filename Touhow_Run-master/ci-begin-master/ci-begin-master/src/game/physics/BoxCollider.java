package game.physics;

import game.GameObject;
import game.Vector2D;

public class BoxCollider {
    public int width;
    public int heght;
    public Vector2D position;

    public BoxCollider(GameObject master, int width, int heght){
        this.position = master.position;
        this.width = width;
        this.heght = heght;
    }

    public double top(){
        return position.y;
    }
    public double bot(){
        return this.top()+ this.heght;
    }
    public double left(){
        return position.x;
    }
    public double right(){
        return this.left()+this.width;
    }

    public boolean intersects(BoxCollider other){
        // this có giao với box truyền vào hay không (other)
        return other.bot() >= this.top()
                && other.top() <= this.bot()
                && other.right() >= this.left()
                && other.left() <= this.right();

    }
}
