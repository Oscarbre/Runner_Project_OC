package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LifeCount extends StaticThing{

    private ImageView img;
    private Integer Nboflives;

    public LifeCount(double l, double h, String path) {
        super(l, h, path);
        Image spriteSheet = new Image(path);
        this.img = new ImageView(spriteSheet);
        this.Nboflives=5;

    }


    public void lifelost(){
        this.img.setViewport(new Rectangle2D(0,10+(5-this.Nboflives)*110,499,118));
    }
}
