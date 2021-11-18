package com.company;

import javafx.geometry.Rectangle2D;

/** Classe qui définit les coordonnées de la caméra */


public class Camera {
    private Integer X;
    private Integer Y;
    private Integer windowSizeX;
    private Integer windowSizeY;
    private Rectangle2D view;

    public Camera(Integer X,Integer Y,Integer windowSizeX,Integer windowSizeY){
        this.X=X;
        this.Y=Y;
        this.windowSizeX=windowSizeX;
        this.windowSizeY=windowSizeY;
        this.view= new Rectangle2D(X,Y,windowSizeX,windowSizeY);
    }



        /** Setter et Getter */

    public Integer getX() {
        return X;
    }

    public Integer getY() {
        return Y;
    }

    public void setXpos(Integer x) {
        this.X=x;
        this.view=new Rectangle2D(x,this.getY(),this.windowSizeX,this.windowSizeY);}

    public void setYpos(Integer y) {
        this.Y=y;
        this.view=new Rectangle2D(this.getX(),y,this.windowSizeX,this.windowSizeY);}

        @Override                                            // pour changer le toString de base
    public String toString() {
        return ("Camera coordinates :" + X + ',' + Y);
    }
}
