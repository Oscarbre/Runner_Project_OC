package com.company;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


/** Classe qui définit une scène et les objets présents dessus, notamment :
 * - Background
 * - Caméra
 * - Héros
 */

public class GameScene extends Scene {


    private Camera Cam;
    private StaticThing left;
    private StaticThing right;
    private Hero hero= new Hero(500,430 ,0,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\heros.png", 84, 100 );;

    public GameScene(Pane root, double width, double height, boolean depthbuffer) {
        super(root,width, height, depthbuffer);
        this.Cam = new Camera(800,420,200,200);
        this.left = new StaticThing(800,600,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.right = new StaticThing(800,600,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");

            /** Initialisation du background */
        left.getImg().setX(0);
        left.getImg().setY(0);
        right.getImg().setX(800);
        right.getImg().setY(0);
        root.getChildren().add(left.getImg());
        root.getChildren().add(right.getImg());

        root.getChildren().add(hero.getImgAT());

        timer.start();

    }




        /** Mise en place du timer pour les animations : une animation toutes les 8ms */

    private long lastUpdate=0;
    private Integer decalage =0;


    private AnimationTimer timer = new AnimationTimer()
       {public void handle(long now){
        if (now - lastUpdate >= 80000000) {
            hero.update();
            update();
            lastUpdate=now;
            //      Cam.update(time);
        }
        }
    };

        /** Setter et Getter */

    public AnimationTimer getTimer() {
        return timer;
    }

        /** Fonction d'actualisation de la scène */

    public void update(){
        decalage=(decalage+10)%800;
        left.getImg().setViewport(new Rectangle2D(0,0,800-decalage,600));
        right.getImg().setViewport(new Rectangle2D(800-decalage,0,decalage,600));

      //  hero.setXpos(hero.getXpos()+10);
       // hero.setY(hero.getYpos()+1);
    }





}
