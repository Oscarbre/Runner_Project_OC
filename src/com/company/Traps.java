package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Traps extends StaticThing{

    private ImageView img;

    public Traps(double l, double h, String path) {
        super(l, h, path);
        Image spriteSheet = new Image(path);
        this.img = new ImageView(spriteSheet);
    }
}
