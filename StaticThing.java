package com.company;

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
        img.setPreserveRatio(false);
        Nboflives=0;
    }


    public ImageView getImg() {
        return img;
    }

    public Integer Lifelose(){
        this.Nboflives=this.Nboflives-1;
        return Nboflives;
    }
    public Integer Lifegain(){
        this.Nboflives=this.Nboflives+1;
        return Nboflives;
    }



}
