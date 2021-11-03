package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView img;
    private Integer attitude;
    private String path;

    private Integer index;
    private Integer indexMax=16;
    private Integer timeframe;
    private Integer windowSizeX;
    private Integer windowSizeY;
    private Integer offset;
    private Rectangle2D frame;


    public AnimatedThing(double x,double y,Integer attitude,String path, Integer windowSizeX,Integer windowSizeY) {
        this.x = x;
        this.y = y;
        Image spriteSheet = new Image(path);
        this.img = new ImageView(spriteSheet);
        this.img.setX(x);
        this.img.setY(y);
        this.attitude = attitude;
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
        index = 1;
        frame = new Rectangle2D(20, 0, windowSizeX, windowSizeY);

        }


    public ImageView getImgAT() {
        return img;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void update() {
        if (attitude==0) {
            index = (index + 1) % 6;
            this.img.setViewport(new Rectangle2D( 84 * (index), 0,this.windowSizeX, this.windowSizeY));
        }
        
    }
}

