package com.company;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;


/** Classe qui définit les objets présents sur la scène, notamment :
 * - Background
 * - Caméra
 * - Héros
 */

public class GameScene extends Scene {


    public GameScene(Parent parent) {
        super(parent);

    }

     public static Camera Cam = new Camera(800,420,200,200);
     public static StaticThing left = new StaticThing(800,600,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
     public static StaticThing right = new StaticThing(800,600,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
     public static Hero Hero= new Hero(800,420 ,0,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\heros.png", 84, 100 );


        /** Mise en place du timer pour les animations : une animation toutes les 8ms */

     public static long lastUpdate=0;

     public static AnimationTimer timer = new AnimationTimer()
        {public void handle(long now){
         if (now - lastUpdate >= 80000000) {
             Hero.update();
             lastUpdate=now;
             //      Cam.update(time);
             //      GameScene.update(time);
         }
         }
     };


    public AnimationTimer getTimer() {
        return timer;
    }
}
