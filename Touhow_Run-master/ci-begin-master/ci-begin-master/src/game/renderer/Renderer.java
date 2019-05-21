package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int curentImageIndex;
    public int frameCount;

    public Renderer(String url){
        File source = new File(url);
        if (source.exists() && source.isFile()){
            image = SpriteUtils.loadImage(url);
        }
        if (source.exists() && source.isDirectory()){
            images = SpriteUtils.loadImages(url);
            curentImageIndex =0;
            frameCount =0;
        }
    }

    public void render(Graphics g, GameObject mater){
        // vẽ 1 ảnh
        if (image != null){
            g.drawImage(image,(int)mater.position.x, (int)mater.position.y, null);
        }
        // vẽ nhiều ảnh
        if (images != null){
            BufferedImage currentImage = images.get(curentImageIndex);
            g.drawImage(currentImage,(int)mater.position.x,(int)mater.position.y,null);
            frameCount++;
            if (frameCount > 6){
                curentImageIndex++;
                if (curentImageIndex >= images.size()){
                    curentImageIndex = 0;
                }
                frameCount = 0;
            }
        }
    }
}