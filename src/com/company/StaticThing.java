package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

    /** Classe qui définit les objets statiques notamment :
    * - Background
    * - Nombre de vie restantes
    */

public class StaticThing {
    private double length;
    private double height;
    private String path;
    private ImageView img;
    private Integer Nboflives;

    public StaticThing(double l,double h,String path){
        this.path=path;
        Image spriteSheet = new Image(path);
        this.img = new ImageView(spriteSheet);
        this.length=l;
        this.height=h;
        img.setFitHeight(h);
        img.setFitWidth(l);
        img.setPreserveRatio(true);
    }


    public ImageView getImg() {
        return img;
    }



}
