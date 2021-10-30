package com.company;

    /** Classe qui définit les coordonnées de la caméra */


public class Camera {
    private Integer X;
    private Integer Y;

    public Camera(Integer X,Integer Y){
        this.X=X;
        this.Y=Y;
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
