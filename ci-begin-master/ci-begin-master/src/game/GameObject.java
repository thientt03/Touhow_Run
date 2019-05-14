package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {//player, background, playerBullet
    //quản lí đối tượng(static)
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle(Class<E> cls){
        //tìm phần tử bị deaactive >> reset phần tử >> trả về
        //nếu không thấy thì tạo mới >> trả về
        E object = findInactive(cls);
        if(object != null){
            object.reset();
            return object;
        }
        try {
            object = cls.getConstructor().newInstance();
            return object;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public static <E extends GameObject> E  findInactive(Class<E> cls){//Player.class || Background.class
        for (int i =0; i< objects.size(); i++){
            GameObject object = objects.get(i);
            //cls truyền vào
            //objectactive == false
            if (cls.isAssignableFrom(object.getClass())&& !object.active){
                return (E)object;
            }
        }

        return null;
    }
    //định nghĩa đối tượng
    public BufferedImage image;
    public Vector2D position;
    public boolean active;

    public GameObject(){
        objects.add(this);
        position = new Vector2D();//vị trí mặc định (0,0)
        active = true;
    }

    //hàm vẽ ảnh
    public void render(Graphics g){
        if (image != null){
            g.drawImage(image,(int)position.x,(int)position.y,null);
        }
    }

    //hàm xử lí logic
    public void run(){

    }

    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }

}
