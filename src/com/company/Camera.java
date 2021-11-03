package com.company;

    /** Classe qui définit les coordonnées de la caméra */


public class Camera {
    private Integer X;
    private Integer Y;
    private Integer windowSizeX;
    private Integer windowSizeY;

    public Camera(Integer X,Integer Y,Integer windowSizeX,Integer windowSizeY){
        this.X=X;
        this.Y=Y;
        this.windowSizeX=windowSizeX;
        this.windowSizeY=windowSizeY;
    }

    public Integer getX() {
        return X;
    }

    public Integer getY() {
        return Y;
    }

    @Override                                            // pour changer le toString de base
    public String toString() {
        return ("Camera coordinates :" + X + ',' + Y);
    }
}
