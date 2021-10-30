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
    private Rectangle2D frame = new Rectangle2D(20,0,65,100);

    public AnimatedThing(double x,double y,Integer attitude,String path){
        this.x=x;
        this.y=y;
        Image spriteSheet = new Image(path);
        this.img = new ImageView(spriteSheet);
        this.attitude=attitude;
    }

    public ImageView getImgAT() {
        return img;
    }
}
