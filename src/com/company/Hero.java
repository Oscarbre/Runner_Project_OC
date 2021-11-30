package com.company;

import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {


    private double invincibility =0; // = 250000000

    public Hero(double x,double y,Integer attitude,String path, Integer windowSizeX,Integer windowSizeY) {
        super(x,y,attitude,path,windowSizeX,windowSizeY);


    }

    public void setInvincibility(double invincibility) {
        this.invincibility = invincibility;
    }

    public double getInvincibility() {
        return invincibility;
    }

    public void jump(){
        this.setAttitude(1);
    }

    public boolean isInvicible(){
        if (this.invincibility>0) {
            return true;
        }else{
            return false;
        }
    }



}
