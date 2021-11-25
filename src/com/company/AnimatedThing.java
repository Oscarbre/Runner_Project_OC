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

    private Integer divfreq=0;
    private Integer i =23;


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

        /** Setter et Getter */

    public ImageView getImgAT() {
        return img;
    }

    public void setXpos(double x) {
        this.getImgAT().setX(x);
        this.x=x;
    }

    public void setYpos(double y) {
        this.getImgAT().setY(y);
        this.y=y;
    }

    public double getXpos() {
        return img.getX();}

    public double getYpos() {
        return img.getY();}

    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }

    public Integer getAttitude() {
        return attitude;
    }

    /** fonction d'actualisation du héros */

    public void update() {
        divfreq+=1; //permet de mieux associer vitesse du background/vitesse du héros

        // "Running"
        if (attitude==0 & divfreq%5==0) {
            index = (index + 1) % 6;
            this.img.setViewport(new Rectangle2D( 84 * (index), 0,this.windowSizeX, this.windowSizeY));
        }

        // "Jumping" (up)
        if (attitude==1 ) {
            this.img.setViewport(new Rectangle2D(0, 120, this.windowSizeX, this.windowSizeY+30));
            if (i==0) {
                this.setAttitude(-1);
            }
            this.setYpos(this.getYpos() - i);
            i-=1;
        }

        // "Jumping" (down)
        if (attitude==-1 ) {
            this.img.setViewport(new Rectangle2D( 84 , 120,this.windowSizeX, this.windowSizeY+30));
            if(i==22){
                i+=1;
                this.img.setViewport(new Rectangle2D( 0 , 0,this.windowSizeX, this.windowSizeY));
                this.setYpos(230);
                this.setAttitude(0);
            }
            i+=1;
            this.setYpos(this.getYpos()+i);
        }

        
    }
}

